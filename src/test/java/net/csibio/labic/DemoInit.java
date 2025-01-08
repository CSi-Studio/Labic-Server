package net.csibio.labic;

import net.csibio.labic.domain.db.User;
import net.csibio.labic.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 30397
 * @version 1.0
 * @description: TODO
 * @date 2025/1/6 15:28
 */
@SpringBootTest
public class DemoInit {

    @Autowired
    LoginService loginService;

    @Test
    public void init() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        loginService.register(user);
    }

}
