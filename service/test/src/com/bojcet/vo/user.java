package com.bojcet.vo;

import java.io.Serializable;

public class user implements Serializable {//序列化，javabean
   // private int userid;
    private String username;
    private String userpassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
