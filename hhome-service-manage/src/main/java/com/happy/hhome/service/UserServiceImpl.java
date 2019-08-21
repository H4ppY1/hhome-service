package com.happy.hhome.service;

import com.happy.hhome.bean.UserDO;
import com.happy.hhome.bean.UserDTO;
import com.happy.hhome.bean.UserQuery;
import com.happy.hhome.converter.user.UserConverter;
import com.happy.hhome.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserConverter userConverter;

    @Override
    public void insertUser(UserDTO userDTO) {
        UserDO userDO = userConverter.toDO(userDTO);
        userMapper.insert(userDO);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        UserDO userDO = userConverter.toDO(userDTO);
        userMapper.delete(userDO);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserDO userDO = userConverter.toDO(userDTO);
        userMapper.updateByPrimaryKeySelective(userDO);
    }

    @Override
    public void listUser(UserQuery userQuery) {
        UserDO userDO = userConverter.toDO(userQuery);
        userMapper.select(userDO);
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userDTO.getUserName());
        Integer count = userMapper.selectCount(userDO);
        if (0 != count) {
//            throw new Exception("用户名已存在");
        }
        userDTO.setPassword(DigestUtils.md5DigestAsHex(userDTO.getPassword().getBytes()));
        userDO = userConverter.toDO(userDTO);

        userMapper.insert(userDO);
    }
}
