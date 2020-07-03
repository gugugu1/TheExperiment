package com.bojcet.service;

import com.bojcet.dao.userDAOIml;
import com.bojcet.vo.user;

public class userService {
    private userDAOIml userdao=null;
    public userService(){
        userdao=new userDAOIml();
    }
    public  boolean add(user user1){
        return userdao.add(user1);
    }
    public  boolean queryAll(user user2){
        return userdao.queryAll(user2);
    }
}
