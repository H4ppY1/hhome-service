package com.happy.hhome.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testHah() {
        return "hah";
    }
}
