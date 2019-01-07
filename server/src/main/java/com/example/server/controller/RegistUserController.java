package com.example.server.controller;

import com.example.server.form.UserForm;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regist")
public class RegistUserController{
    @ModelAttribute
    public UserForm setUserForm(){
        return new UserForm();
    }
    
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(UserForm user){
        return user.getUserCd() + " / " + user.getUserName();
    }
}