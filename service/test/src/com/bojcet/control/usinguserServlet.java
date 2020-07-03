package com.bojcet.control;

import com.bojcet.service.usinguserService;
import com.bojcet.vo.usinguser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "usinguserServlet" ,urlPatterns = "/usinguser")
public class usinguserServlet extends HttpServlet {
    private usinguserService usinguserService=new usinguserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        RequestDispatcher dispatcher=null;
        switch (action){
            case "show":
                List<usinguser> list=usinguserService.queryAll();
                request.setAttribute("list",list);//向前台传值
               dispatcher=request.getRequestDispatcher("/manage.jsp");//转发

                //response.sendRedirect("manage.jsp");
                dispatcher.forward(request,response);
                break;
            case  "del":
                String usingid=request.getParameter("usingid");
                usinguserService.del(usingid);
                //dispatcher=request.getRequestDispatcher("");
                response.sendRedirect("usinguser?action=show");//重定向

                break;

            case "tiao" :

               dispatcher=request.getRequestDispatcher("/update.jsp");
                dispatcher.forward(request,response);
                //response.sendRedirect("update.jsp");
                break;
            case "edit":
                //java.lang.NumberFormatException: null
                usinguser usinguser4=new usinguser();
                usinguser4.setUsingid((request.getParameter("usingid")));
                usinguser4.setUsingname(request.getParameter("usingname"));
                usinguser4.setUsingpassword(request.getParameter("usingpassword"));
                usinguser4.setUsingphone(request.getParameter("usingphone"));
                usinguser4.setUsingemail(request.getParameter("usingemail"));
                usinguser4.setUsingdescribe(request.getParameter("usingdescribe"));
                usinguserService.edit(usinguser4);
                //dispatcher=request.getRequestDispatcher("usinguser?action=show");
                response.sendRedirect("usinguser?action=show");
                break;
            case "add":
                usinguser usinguser1=new usinguser();
                usinguser1.setUsingid((request.getParameter("usingid")));
                usinguser1.setUsingname(request.getParameter("usingname"));
                usinguser1.setUsingpassword(request.getParameter("usingpassword"));
                usinguser1.setUsingphone(request.getParameter("usingphone"));
                usinguser1.setUsingemail(request.getParameter("usingemail"));
                usinguser1.setUsingdescribe(request.getParameter("usingdescribe"));
                usinguserService.add(usinguser1);
                //dispatcher=request.getRequestDispatcher("usinguser?action=show");
                response.sendRedirect("usinguser?action=show");
                break;
            case "select":
                usinguser usinguser2=new usinguser();
                usinguser2.setUsingid((request.getParameter("query")));
                List<usinguser> list1=usinguserService.select(usinguser2);
                request.setAttribute("list",list1);//向前台传值
                dispatcher=request.getRequestDispatcher("/query.jsp");
                dispatcher.forward(request,response);
               // response.sendRedirect("query.jsp");
                break;
        }
       // dispatcher.forward(request,response);
    }
}
