package com.happy.hhome.controller;

import com.happy.hhome.bean.UserDTO;
import com.happy.hhome.service.UserService;
import com.happy.hhome.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class LoginRegisterController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public void register(UserDTO userDTO) {
        userService.registerUser(userDTO);
    }

    @RequestMapping("/login")
    public Result login(UserDTO userDTO, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userDTO.getUserName(), userDTO.getPassword());
        subject.login(token);
        UserDTO user = new UserDTO();
// todo UserDTO user = userService.getUserByUserName(userDTO.getUserName());
        session.setAttribute("user", user);
        return Result.success();
    }


}
