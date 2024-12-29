package net.csibio.labic.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.UserDO;
import net.csibio.labic.domain.vo.LoginVO;
import net.csibio.labic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginVO login) {
        return userService.login(login.getUsername(), login.getPassword());
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
    public Result init(){
        System.out.println("Hello World");
        UserDO user = new UserDO();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.register(user);
        return Result.OK();
    }
}
