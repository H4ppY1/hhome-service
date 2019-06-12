package com.happy.hhome.controller;

import com.happy.hhome.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class UserManageController {

    @Resource
    private UserService userService;

}
