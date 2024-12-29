package net.csibio.labic.service;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.UserDO;
import net.csibio.labic.enums.ResultCode;
import net.csibio.labic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String LOCK_PREFIX = "user:lock:";
    private static final String ERROR_COUNT_PREFIX = "user:error_count:";
    private static final int MAX_ERROR_COUNT = 5;
    private static final int LOCK_DURATION = 15; // 15分钟
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Result login(String username, String password) {
        UserDO user = userRepository.findByUsername(username);
        if (user == null) {
            return Result.Error(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }

        if (isAccountLocked(username)) {
            return Result.Error(ResultCode.ACCOUNT_LOCKED);
        }

        if (!passwordEncoder.matches(password, user.getPassword()+user.getSalt())) {
            int errorCount = incrementErrorCount(username);
            if (errorCount >= MAX_ERROR_COUNT) {
                lockAccount(username);
                return Result.Error(ResultCode.ACCOUNT_LOCKED);
            }
            return Result.Error(ResultCode.USERNAME_OR_PASSWORD_ERROR);
        }

        clearErrorCount(username);
        return Result.OK();
    }

    public Result register(UserDO user) {
        if (user.getUsername().length() > 25 || user.getPassword().length() > 25) {
            return Result.Error(ResultCode.USERNAME_OR_PASSWORD_LENGTH_MUST_LESS_THAN_25);
        }

        String salt = generateSalt(6);
        user.setSalt(salt);
        user.setPassword(passwordEncoder.encode(user.getPassword()+user.getSalt()));
        userRepository.save(user);
        return Result.OK();
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
