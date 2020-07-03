package com.bojcet.dao;

import com.bojcet.db.DB;
import com.bojcet.vo.usinguser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usinguserDAOIml {
    private Connection connection;
    public usinguserDAOIml(){
        connection= DB.getConnection();
    }
    public List<usinguser> queryAll() {
        List<usinguser> list=new ArrayList<>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try{
            String sql="select * from usinguser order by usingid desc";
            pstm=connection.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                usinguser usinguser=new usinguser();
                usinguser.setUsingid(rs.getString("usingid"));
                usinguser.setUsingname(rs.getString("usingname"));
                usinguser.setUsingpassword(rs.getString("usingpassword"));
                usinguser.setUsingphone(rs.getString("usingphone"));
                usinguser.setUsingemail(rs.getString("usingemail"));
                usinguser.setUsingdescribe(rs.getString("usingdescribe"));
                list.add(usinguser);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
    public boolean add(usinguser usinguser){
        PreparedStatement pstm=null;
        boolean flag=false;
        String sql="insert into usinguser(usingid,usingname,usingpassword,usingphone,usingemail,usingdescribe) values(?,?,?,?,?,?)";

        try {
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,usinguser.getUsingid());
            pstm.setString(2,usinguser.getUsingname());
            pstm.setString(3,usinguser.getUsingpassword());
            pstm.setString(4,usinguser.getUsingphone());
            pstm.setString(5,usinguser.getUsingemail());
            pstm.setString(6,usinguser.getUsingdescribe());
            flag=pstm.executeUpdate()>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }
    public List<usinguser> select(usinguser usinguser1){
        List<usinguser> list=new ArrayList<>();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String sql="select * from usinguser where usingid=?";

        try {
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,usinguser1.getUsingid());
            rs=pstm.executeQuery();
            while(rs.next()){
                usinguser usinguser=new usinguser();
                usinguser.setUsingid(rs.getString("usingid"));
                usinguser.setUsingname(rs.getString("usingname"));
                usinguser.setUsingpassword(rs.getString("usingpassword"));
                usinguser.setUsingphone(rs.getString("usingphone"));
                usinguser.setUsingemail(rs.getString("usingemail"));
                usinguser.setUsingdescribe(rs.getString("usingdescribe"));
                list.add(usinguser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return list;
    }
    public usinguser select1(String usingid1){
        PreparedStatement pstm=null;
        ResultSet rs=null;
        String sql="select * from usinguser where usingid=?";
        usinguser usinguser=new usinguser();
        //int usingid=Integer.parseInt(usingid);
        try {
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,usingid1);
            rs=pstm.executeQuery();
            while(rs.next()){

                usinguser.setUsingid(rs.getString("usingid"));
                usinguser.setUsingname(rs.getString("usingname"));
                usinguser.setUsingpassword(rs.getString("usingpassword"));
                usinguser.setUsingphone(rs.getString("usingphone"));
                usinguser.setUsingemail(rs.getString("usingemail"));
                usinguser.setUsingdescribe(rs.getString("usingdescribe"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return usinguser;
    }
    public boolean del(String usingid){
        boolean flag=false;
        //int usingid=Integer.parseInt(usingid1);
        PreparedStatement pstm=null;
        String sql="delete from usinguser where usingid=?";
        try{

            pstm=connection.prepareStatement(sql);
            pstm.setString(1,usingid);
            flag=pstm.executeUpdate()>0?true:false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            if(pstm!=null){
//                try {
//                    pstm.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return flag;
    }
    public boolean edit(usinguser usinguser){
        boolean flag=false;
        PreparedStatement pstm=null;

        try {
            String sql="update usinguser set usingid=?,usingname=?,usingpassword=?,usingphone=?,usingemail=?,usingdescribe=? where usingid=?";
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,usinguser.getUsingid());
            pstm.setString(2,usinguser.getUsingname());
            pstm.setString(3,usinguser.getUsingpassword());
            pstm.setString(4,usinguser.getUsingphone());
            pstm.setString(5,usinguser.getUsingemail());
            pstm.setString(6,usinguser.getUsingdescribe());
            pstm.setString(7,usinguser.getUsingid());
            flag=pstm.executeUpdate()>0?true:false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            if(pstm!=null){
//                try {
//                    pstm.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }


        return flag;

    }


}
