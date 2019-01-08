package com.example.server.controller;

import javax.inject.Inject;

import com.example.server.domain.User;
import com.example.server.form.UserForm;
import com.example.server.service.UserService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regist")
public class RegistUserController{
    @Inject
    UserService userService;

    @ModelAttribute
    public UserForm setUserForm(){
        return new UserForm();
    }
    
    @RequestMapping(value = "addUser",method = RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addUser(UserForm userForm){
        return userForm.getUserCd() + " / " + userForm.getUserName();
    }

    @RequestMapping(value = "getUserInfo",method = RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User getUserInfo(UserForm userForm){
        System.out.println("user : " + userForm.toString());
        return userService.getUserInfo(userForm.getUserCd());
    }
}