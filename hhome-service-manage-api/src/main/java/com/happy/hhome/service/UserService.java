package com.happy.hhome.service;

import com.happy.hhome.bean.UserDTO;
import com.happy.hhome.bean.UserQuery;

public interface UserService {
    void insertUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
    void updateUser(UserDTO userDTO);
    void listUser(UserQuery userQuery);

    void registerUser(UserDTO userDTO);
}
