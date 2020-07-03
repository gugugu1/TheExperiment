package com.bojcet.service;

import com.bojcet.dao.usinguserDAOIml;
import com.bojcet.vo.usinguser;

import java.util.List;

public class usinguserService {

    private usinguserDAOIml usingdao=null;
    public usinguserService(){
        usingdao=new usinguserDAOIml();
    }
    public List<usinguser> queryAll(){
        return usingdao.queryAll();
    }
    public boolean add(usinguser usinguser){
        return usingdao.add(usinguser);
    }
    public List<usinguser> select(usinguser usinguser){
        return usingdao.select(usinguser);
    }


    public usinguser select1(String usingid){
        return usingdao.select1(usingid);
    }

    public boolean edit(usinguser usinguser){
        return usingdao.edit(usinguser);
    }
    public boolean del(String usingid){
        return usingdao.del(usingid);
    }



}
