package com.happy.hhome.service;

import com.happy.hhome.bean.UserDO;
import com.happy.hhome.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String testHah() {
        UserDO userDO = new UserDO();
        userDO.setUserId(1);
        userDO = userMapper.selectByPrimaryKey(userDO);
        return userDO.toString();
    }
}
