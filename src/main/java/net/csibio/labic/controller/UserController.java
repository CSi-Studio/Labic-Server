package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.User;
import net.csibio.labic.domain.query.UserQuery;
import net.csibio.labic.domain.vo.UserVO;
import net.csibio.labic.enums.ResultCode;
import net.csibio.labic.repository.UserRepository;
import net.csibio.labic.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/list")
    Result list(UserQuery query) {
        Pageable pageable = PageRequest.of(query.getCurrent() - 1, query.getPageSize());
        Page<User> userPage = userRepository.findAll(pageable);
        return Result.OK(userPage.getContent(), userPage.getNumber(), userPage.getTotalPages());
    }

    @PostMapping(value = "/add")
    Result add(User userToSave) {
        Result result = loginService.register(userToSave);
        return result;
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        userRepository.deleteAllById(ids);
        return Result.OK();
    }

    @PostMapping(value = "/update")
    Result update(UserVO userToUpdate) {
        User user = userRepository.findById(userToUpdate.getId()).orElse(null);
        if (user != null) {
            BeanUtils.copyProperties(userToUpdate, user);
            userRepository.save(user);
            return Result.OK();
        } else {
            return Result.Error(ResultCode.USER_NOT_EXISTED);
        }
    }
}
