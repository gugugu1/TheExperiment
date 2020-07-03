package com.bojcet.vo;

import java.io.Serializable;

public class usinguser implements Serializable {//javabean
    private String usingid;
    private String usingname;
    private String usingphone;
    private String usingemail;
    private String usingdescribe;
    public usinguser(){}
    public usinguser(String usingid, String usingpassword) {//登录使用 id，密码
        this.usingid = usingid;
        this.usingpassword = usingpassword;
    }
//  注册账号使用 id，用户名，密码，电话，邮箱
    public usinguser(String usingid, String usingname, String usingpassword, String usingphone, String usingemail) {
        this.usingid = usingid;
        this.usingname = usingname;
        this.usingpassword = usingpassword;
        this.usingphone = usingphone;
        this.usingemail = usingemail;

    }

    //    private String usingsex;
    private String usingpassword;

    public String getUsingpassword() {
        return usingpassword;
    }

    public void setUsingpassword(String usingpassword) {
        this.usingpassword = usingpassword;
    }


    public String getUsingid() {
        return usingid;
    }

    public void setUsingid(String usingid) {
        this.usingid = usingid;
    }

    public String getUsingname() {
        return usingname;
    }

    public void setUsingname(String usingname) {
        this.usingname = usingname;
    }

//    public String getUsingsex() {
//        return usingsex;
//    }
//
//    public void setUsingsex(String usingsex) {
//        this.usingsex = usingsex;
//    }

    public String getUsingphone() {
        return usingphone;
    }

    public void setUsingphone(String usingphone) {
        this.usingphone = usingphone;
    }

    public String getUsingemail() {
        return usingemail;
    }

    public void setUsingemail(String usingemail) {
        this.usingemail = usingemail;
    }

    public String getUsingdescribe() {
        return usingdescribe;
    }

    public void setUsingdescribe(String usingdescribe) {
        this.usingdescribe = usingdescribe;
    }

    @Override
    public String toString() {
        return "usinguser [usingid=" + usingid + ", usingname=" + usingname + ", usingpassword=" + usingpassword
                + ", usingphone=" + usingphone +",usingemail="+usingemail+ "]";
    }


}
