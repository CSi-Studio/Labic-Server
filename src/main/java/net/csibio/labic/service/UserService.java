package net.csibio.labic.service;

import cn.dev33.satoken.stp.StpUtil;
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

@Service
public class UserService {

}
