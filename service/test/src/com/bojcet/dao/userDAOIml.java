package com.bojcet.dao;

import com.bojcet.db.DB;
import com.bojcet.vo.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAOIml {
    private Connection connection;
    public userDAOIml(){
        connection= DB.getConnection();
    }
    public boolean queryAll(user user2){
        PreparedStatement pstm=null;
        ResultSet rs=null;
        boolean flag=false;
        try{
            String sql="select * from user where username=? and userpassword=? ";
            pstm=connection.prepareStatement(sql);
          //  pstm.setInt(1,user2.getUserid());
            pstm.setString(1,user2.getUsername());
            pstm.setString(2,user2.getUserpassword());
            rs=pstm.executeQuery();
            while(rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            //DB.closeConnection();
        }

        return flag;

    }

    public boolean add(user user1){
        PreparedStatement pstm=null;
        ResultSet rs=null;
        boolean flag=false;
        try {

            String sql="insert into user (username,userpassword) values(?,?)";
            pstm=connection.prepareStatement(sql);
          //  pstm.setInt(1,user1.getUserid());
            pstm.setString(1,user1.getUsername());
            pstm.setString(2,user1.getUserpassword());

            flag=pstm.executeUpdate()>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //DB.closeConnection();
        }
        return flag;
    }
}
