package com.example.server.repository;

import javax.inject.Inject;

import com.example.server.domain.User;
import com.example.server.mapper.UserMapper;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Inject
    private UserMapper userMapper;

    public User userInfo(String userCd){
        return userMapper.userInfo(userCd);
    }
}