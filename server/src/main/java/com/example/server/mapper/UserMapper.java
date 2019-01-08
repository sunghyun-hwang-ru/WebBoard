package com.example.server.mapper;

import com.example.server.domain.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{
    User userInfo(String userCd);
}