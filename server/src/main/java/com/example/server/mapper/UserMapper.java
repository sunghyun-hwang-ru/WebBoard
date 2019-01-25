package com.example.server.mapper;

import java.util.Map;

import com.example.server.domain.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{
    User userInfo(String userCd);

    Map<String, Object> login(User user);
}