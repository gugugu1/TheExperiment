package com.bojcet.control;

import com.bojcet.service.userService;
import com.bojcet.vo.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "userServlet" ,urlPatterns = "/user")
public class userServlet extends HttpServlet {
    private userService userService=new userService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        RequestDispatcher dispatcher=null;
        switch (action){
            case "add":
                user user=new user();
              //  user.setUserid(Integer.getInteger(request.getParameter("userid")));
                user.setUsername(request.getParameter("username"));
                user.setUserpassword(request.getParameter("userpassword"));
                if(userService.add(user)==true){
                    //dispatcher=request.getRequestDispatcher("/index.jsp");
                    response.sendRedirect("/user?action=index");
                }else{
                    response.setContentType("text/html;charset=GB2312");
                    PrintWriter out = response.getWriter();

                    out.print("注册失败请重新尝试,用户名可能重复");
                }
                //dispatcher.forward(request,response);

                break;
            case "login":
                user user1=new user();
              //  user1.setUserid(Integer.getInteger(request.getParameter("userid")));
                user1.setUsername(request.getParameter("username"));
                user1.setUserpassword(request.getParameter("userpassword"));

                if(userService.queryAll(user1)==true){
                    dispatcher=request.getRequestDispatcher("/usinguser?action=show");
                    //response.sendRedirect("/usinguser?action=show");
                }
                else{
                    response.setContentType("text/html;charset=GB2312");
                    PrintWriter out = response.getWriter();

                    out.print("请输入正确的用户名和密码");
                }
                dispatcher.forward(request,response);
                break;
            case "index":
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
                break;
            case "logout":

                response.sendRedirect("/user?action=index");
                break;
        }

    }
}
