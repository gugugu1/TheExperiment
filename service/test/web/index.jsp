<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/4 0004
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>客户管理系统</title>
  <script>
      function submit(){
         // var userid=document.getElementById("userid");
          var username=document.getElementById("username");
          var password=document.getElementById("userpassword");
          var yzm=document.getElementById("k");

          if(username.value.length==0){
              alert("用户名不能为空")
              username.focus();
              return false;
          }
          if(password.value.length==0){
              alert("密码不能为空")
              password.focus();
              return false;
          }
          if(yzm.value.length==0){
              alert("请输入验证码")
              yzm.focus();
              return false;
          }
      }
      function checkcode()
      {
          var s;
          s=1000+Math.floor(Math.random()*9000);
          return s;
      }

      var num;
      function scanfin()
      {
          var s;
          s=document.getElementById("k");
          if(parseInt(s.value)!=num)
              alert("验证码输入错误,请重新输入!");
          if(parseInt(s.value).length==0){
              alert("验证码为空,请输入!");
          }
      }
      function product()
      {
          s=1000+Math.floor(Math.random()*9000);
          num=s;
          var v=document.getElementById("code");
          v.innerHTML=num;
      }
  </script>
</head>
<body background="img/index.jpg">
<h2 align="center">客户管理系统</h2>
<table align="center" border="0">
  <form action="/user?action=login" method="post" id="login" name="login">

    <tr>
      <td>用户名</td>
      <td>
        <input type="text" id="username" name="username" >
      </td>
    <tr>
      <td>密&nbsp;&nbsp;码</td>
      <td>
        <input type="password" id="userpassword" name="userpassword">
      </td>
    </tr>
    <tr><td>验证码<td>
                <span  id="code" >
                     <script>
                              num=checkcode();
                              document.write(num);
                      </script>
                </span>
      <input type="text" name="yzm"  size="10" id="k" onblur="scanfin()">
      <input type="button" value="刷新" onclick="product()" >
    </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="登陆" onclick="return submit()">
      </td>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <td>
        <input type="reset" value="重置" placeholder="重置">
      </td>
    </tr>
    <tr>
      <td>
        <p align="center"><a href="register.jsp" color=blue>注册管理员</a></p>
      </td>
    </tr>
  </form>
</table>
</body>
</html>
