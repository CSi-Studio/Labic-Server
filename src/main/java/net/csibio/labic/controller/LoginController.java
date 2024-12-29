package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.UserDO;
import net.csibio.labic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
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
