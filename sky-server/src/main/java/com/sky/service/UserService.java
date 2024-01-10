package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {
    /**
     * 功能描述: 微信登陆
     * @param userLoginDTO
     * @return com.sky.entity.User
     */

    public User wxlogin(UserLoginDTO userLoginDTO);

}
