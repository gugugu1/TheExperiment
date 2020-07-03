<%@ page import="com.bojcet.service.usinguserService" %>
<%@ page import="com.bojcet.vo.usinguser" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10 0010
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户管理系统</title>
    <script>
        function sumbit() {
            var usingid=document.getElementById("usingid");
            var usingname=document.getElementById("usingname");
            var usingpassword=document.getElementById("usingpassword");
            var usingphone=document.getElementById("usingphone");
            var usingemail=document.getElementById("usingemail");
            var usingdescribe=document.getElementById("usingdescribe");
            //var flag=false;
            if(usingid.value.length==0){
                alert("用户ID不能为空");
                usingid.focus();
                return false;
            }
            if(usingname.value.length==0){
                alert("姓名不能为空");
                usingname.focus();
                return false;
            }
            if(usingpassword.value.length==0){
                alert("密码不能为空");
                usingpassword.focus();
                return false;
            }
            if(usingphone.value.length==0){
                alert("手机号不能为空");
                usingphone.focus();
                return false;
            }
            var reg =  /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
            if((!reg.test(usingemail.value))&&usingemail.value.length!=0){
                alert("邮箱格式输入不正确")
                usingemail.focus();
                return false;
            }

        }

    </script>


</head>

<body background="img/update.jpg">
<div align="center">
    <h1>客户管理系统_修改客户信息</h1><hr>
    <form action="/usinguser?action=edit" method="post">
        <%
            usinguserService usinguserService=new usinguserService();
            usinguser usinguser=new usinguser();
            //int usingid=(Integer.parseInt()) ;
            usinguser=usinguserService.select1((request.getParameter("usingid")));
            if(usinguser!=null){
                usinguser.setUsingid(usinguser.getUsingid());
                usinguser.setUsingname(usinguser.getUsingname());
                usinguser.setUsingpassword(usinguser.getUsingpassword());
                usinguser.setUsingphone(usinguser.getUsingphone());
                usinguser.setUsingemail(usinguser.getUsingemail());
                usinguser.setUsingdescribe(usinguser.getUsingdescribe());
            }

        %>
        <table>
            <tr>
                <td>客户ID：</td>
                <td><input type="text" name="usingid" id="usingid" value="<%=usinguser.getUsingid()%>"/></td>
            </tr>
            <tr>
                <td>客户姓名：</td>
                <td><input type="text" name="usingname" id="usingname" value="<%=usinguser.getUsingname()%>"/></td>
            </tr>
            <tr>
                <td>客户密码：</td>
                <td><input type="text" name="usingpassword" id="usingpassword" value="<%=usinguser.getUsingpassword()%>">
                </td>
            </tr>

            <tr>
                <td>手机号码：</td>
                <td><input type="text" name="usingphone" id="usingphone" value="<%=usinguser.getUsingphone()%>"/></td>
            </tr>
            <tr>
                <td>电子邮件：</td>
                <td><input type="text" name="usingemail" id="usingemail" value="<%=usinguser.getUsingemail()%>"/></td>
            </tr>

            <tr>
                <td>描述信息：</td>
                <td>
                    <textarea name="usingdescribe" id="usingdescribe" rows="6" cols="40" ></textarea>
                    <script >
                    document.getElementById("usingdescribe").value="<%=usinguser.getUsingdescribe()%>";
                    </script>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="修改客户信息" onclick="return sumbit()"/></td>
                <td><input type="reset" value="复原"/></td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>

