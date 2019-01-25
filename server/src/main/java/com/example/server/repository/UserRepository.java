package com.example.server.repository;

import java.util.HashMap;
import java.util.Map;

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

    public User login(User user){
        Map<String, Object> map = new HashMap<String, Object>();

        if(!((Integer)map.get("cnt") > 0 && (Integer)map.get("passCnt") > 0)){
            return user;
        }

        return userInfo(user.getUserCd());
    }
}