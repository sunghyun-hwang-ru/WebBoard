package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    @RequestMapping("/")
    public String get(String value){
        if(value == null || "".equals(value.trim())){
            return "HelloController";
        }else{
            return "Hello " + value;
        }
    }
}