package net.csibio.labic.service;

import cn.dev33.satoken.stp.StpUtil;
import net.csibio.labic.constants.LoginType;
import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.UserDO;
import net.csibio.labic.domain.vo.LoginVO;
import net.csibio.labic.enums.ResultCode;
import net.csibio.labic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String LOCK_PREFIX = "user:lock:";
    private static final String ERROR_COUNT_PREFIX = "user:error_count:";
    private static final int MAX_ERROR_COUNT = 5;
    private static final int LOCK_DURATION = 15; // 15分钟
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Result login(LoginVO login) {
        UserDO user = null;
        if (login.getLoginType().equals(LoginType.Account)){
            user = userRepository.findByUsername(login.getUsername());
            if (user == null) {
                return Result.Error(ResultCode.USERNAME_OR_PASSWORD_ERROR);
            }

            if (isAccountLocked(login.getUsername())) {
                return Result.Error(ResultCode.ACCOUNT_LOCKED);
            }

            if (!passwordEncoder.matches(login.getPassword() + user.getSalt(), user.getPassword())) {
                int errorCount = incrementErrorCount(login.getUsername());
                if (errorCount >= MAX_ERROR_COUNT) {
                    lockAccount(login.getUsername());
                    return Result.Error(ResultCode.ACCOUNT_LOCKED);
                }
                return Result.Error(ResultCode.USERNAME_OR_PASSWORD_ERROR);
            }

            clearErrorCount(login.getUsername());
        }

        StpUtil.login(user.getId());
        return Result.OK(StpUtil.getTokenInfo());
    }

    public Result register(UserDO userToSave) {
        if (userToSave.getUsername().length() > 25 || userToSave.getPassword().length() > 25) {
            return Result.Error(ResultCode.USERNAME_OR_PASSWORD_LENGTH_MUST_LESS_THAN_25);
        }

        String salt = generateSalt(6);
        userToSave.setSalt(salt);
        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword() + userToSave.getSalt()));
        UserDO user = userRepository.save(userToSave);
        return Result.OK(user);
    }

    private boolean isAccountLocked(String username) {
        return redisTemplate.hasKey(LOCK_PREFIX + username);
    }

    private int incrementErrorCount(String username) {
        Integer count = (Integer) redisTemplate.opsForValue().get(ERROR_COUNT_PREFIX + username);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        redisTemplate.opsForValue().set(ERROR_COUNT_PREFIX + username, count);
        return count;
    }

    private void clearErrorCount(String username) {
        redisTemplate.delete(ERROR_COUNT_PREFIX + username);
    }

    private void lockAccount(String username) {
        redisTemplate.opsForValue().set(LOCK_PREFIX + username, 1, LOCK_DURATION, TimeUnit.MINUTES);
    }

    public static String generateSalt(int length) {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[length];
        random.nextBytes(saltBytes);
        return String.format("%0" + (saltBytes.length * 2) + "x", new BigInteger(1, saltBytes));
    }

}
