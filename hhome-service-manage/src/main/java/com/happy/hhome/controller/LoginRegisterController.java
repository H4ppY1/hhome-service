package com.happy.hhome.controller;

import com.happy.hhome.bean.UserDTO;
import com.happy.hhome.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginRegisterController {

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public void register(UserDTO userDTO) {
        userService.registerUser(userDTO);
    }

}
