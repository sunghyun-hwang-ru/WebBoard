package com.example.server.form;

import java.io.Serializable;

public class UserForm implements Serializable {
    private static final long serialVersionUID = 8364832583264042025L;

    private String userCd;

    private String userPass;

    private String userName;

    private String email;

    /**
     * @return the userCd
     */
    public String getUserCd() {
        return userCd;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass the userPass to set
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @param userCd the userCd to set
     */
    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }


}