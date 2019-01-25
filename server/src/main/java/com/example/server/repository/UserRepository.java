package com.example.server.repository;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

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
        map = userMapper.login(user);
        if(((BigDecimal)map.get("CNT")).intValue() == 0){
            user.setLoginMsg("該当ユーザが存在しません。");
        }else{
            if(((BigDecimal)map.get("PASS_CNT")).intValue() == 0){
                user.setLoginMsg("パスワードが間違ってます。");
            }else if(((BigDecimal)map.get("DEL_CNT")).intValue() > 0){
                user.setLoginMsg("退会した会員です。");
            }else{
                user = userInfo(user.getUserCd());
                user.setToken("1");
                user.setLoginMsg("Loginしました。");
            }
        }
        
        System.out.println("user : " + user.toString());
        return user;
    }
}