package com.happy.hhome.controller;

import com.happy.hhome.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return testService.testHah();
    }

}
