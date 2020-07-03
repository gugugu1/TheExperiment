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

// 添加所有代码
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private com.bojcet.service.usinguserService usinguserService=new usinguserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //整个登录返回包括两部分，一个是code，0表示注册成功，1表示id已经存在，2表示插入数据库失败；一个是data，注册成功时data是整个user的json，否则是空
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String psd = request.getParameter("psd");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        int code = 0;
        //先检查account是否已经存在
        usinguser existedUser = usinguserService.select1(account);
        usinguser addedUser = null;
        if (existedUser != null && existedUser.getUsingid() != null) {
            //id已经存在
            code = 1;
        } else {
            //不存在，可以注册
            addedUser = new usinguser(account, name, psd, phone, email);
            boolean addSucc = usinguserService.add(addedUser);
            if (!addSucc) {
                code = 2;
            }
        }

        JSONObject json = new JSONObject();
        json.put("data", code == 0 ? addedUser : null);//code==0才返回整个user
        json.put("code", code);
        PrintWriter out = response.getWriter();
        out.write(json.toString());//返回json数据

        out.flush();
        out.close();
    }
}
