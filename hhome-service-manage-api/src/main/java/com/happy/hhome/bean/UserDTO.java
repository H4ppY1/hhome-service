package com.happy.hhome.bean;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String userName;
    private String nickName;
    private String password;
    private String enabled;
    private String email;
    private String userFace;
    private String regTime;
}
