package com.bojcet.control;

import com.alibaba.fastjson.JSONObject;
import com.bojcet.service.usinguserService;
import com.bojcet.vo.usinguser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private com.bojcet.service.usinguserService usinguserService=new usinguserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //整个登录返回包括两部分，一个是code，0表示登录成功，1表示密码错误，2表示没注册；一个是data，登录成功时data是整个user的json，否则是空
        String id = request.getParameter("account");
        String psd = request.getParameter("passwd");
        usinguser user = usinguserService.select1(id);//查出来不存在也不为null，只是字段为null

        int code = 0;
        if (user.getUsingid() != null) {
            //用户已注册，对比密码是否对
            if (psd == null || !psd.equals(user.getUsingpassword())) {
                //密码不对，登录失败，返回密码不对
                code = 1;
            }
        } else {
            //没注册过，登录失败，返回提示去注册
            code = 2;
        }
        JSONObject json = new JSONObject();
        json.put("data", code == 0 ? user : null);//code==0才返回整个user
        json.put("code", code);
        PrintWriter out = response.getWriter();
        out.write(json.toString());//返回json数据


//        List<usinguser> list1=usinguserService.queryAll();
//        PrintWriter out=response.getWriter();
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html");
//        out.print(JSON.toJSON(list1));
//
//
//        JSONObject json = new JSONObject();
//        List<usinguser> list = new ArrayList<>();
//        usinguser user = new usinguser("","","","","");
//        list.add(user);
//        json.put("data", list);
//        PrintWriter out1 = response.getWriter();
//        out1.write(json.toString());//返回json数据


        out.flush();
        out.close();
    }
}
