package com.lancer.service;


import com.lancer.beans.UserInfo;
import com.lancer.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public UserInfo getUserByAccount(String account){
        return userMapper.getUserByAccount(account);
    }

}
