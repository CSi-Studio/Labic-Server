package net.csibio.labic.controller;

import cn.dev33.satoken.stp.StpUtil;
import net.csibio.labic.constants.Role;
import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.UserDO;
import net.csibio.labic.domain.vo.LoginVO;
import net.csibio.labic.enums.ResultCode;
import net.csibio.labic.repository.UserRepository;
import net.csibio.labic.service.LoginService;
import net.csibio.labic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVO login) {
        return loginService.login(login);
    }

    @GetMapping("/currentUser")
    public Result currentUser() {
        try {
            String userId = StpUtil.getLoginIdAsString();
            UserDO user = userRepository.findById(userId).orElse(null);
            if (user == null) {
                return Result.Error(ResultCode.USER_NOT_EXISTED);
            }
            return Result.OK(user);
        } catch (Exception e) {
            return Result.Error(ResultCode.USER_NOT_EXISTED);
        }
    }

    @PostMapping("/logout")
    public Result logout(@RequestParam String username, @RequestParam String password) {
        StpUtil.logout();
        return Result.OK();
    }

    @RequestMapping("tokenInfo")
    public Result tokenInfo() {
        return Result.OK(StpUtil.getTokenInfo());
    }

    @RequestMapping("isLogin")
    public Result isLogin() {
        return Result.OK("是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("/init")
    public Result init() {
        UserDO user = new UserDO();
        user.setUsername("admin");
        user.setName("admin");
        user.setPassword("admin");
        user.setRole(Role.Admin);
        loginService.register(user);
        return Result.OK();
    }
}
