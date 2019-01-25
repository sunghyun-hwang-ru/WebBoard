package com.example.server.service;

import javax.inject.Inject;

import com.example.server.domain.User;
import com.example.server.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService{
    @Inject
    private UserRepository userRepository;

    @Transactional(readOnly=true)
    public User getUserInfo(String userCd){
        return userRepository.userInfo(userCd);
    }

    @Transactional(readOnly = true)
    public User login(User user){
        return userRepository.login(user);
    }
}