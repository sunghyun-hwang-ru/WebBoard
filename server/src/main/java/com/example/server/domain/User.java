package com.example.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User{
    @Getter
    @Setter
    private String userCd;

    @Getter
    @Setter
    private String userPass;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String useYn;

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private String loginMsg;

    @Override
    public String toString(){
        return "User[{"
         + "userCd:" + userCd 
         + ", userPass: " + userPass
         + ", userName: " + userName
         + ", email: " + email
         + ", useYn: " + useYn
         + ", token: " + token
         + ", loginMsg: " + loginMsg
         +"}]";
    }

}