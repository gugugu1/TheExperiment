<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10 0010
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script>
        function submit(){
            var s=document.getElementById("username");
            var p1=document.getElementById("userpassword");
            var p2=document.getElementById("userpassword1");
            var yzm=document.getElementById("yzm");
            if(s.value.length==0)
            {
                alert("用户名不能为空");
                s.focus();
                return false;
            }
            if(p1.value!=p2.value){
                alert("两次密码不一致,请确认密码");
                p1.focus();
                return false;
            }
            if(yzm.value.length==0){
                alert("请输入验证码");
                yzm.focus();
                return false;
            }
        }
        // function check(t)
        // {
        //     var p1,p2;
        //     p1=register.userpassword.value;
        //     p2=register.userpassword1.value;
        //     if()
        //     {}
        // }
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
            if(parseInt(s.value.length)==0){
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
<body background="img/register.jpg">
<h2 align="center">管理员注册</h2>
<table align="center" border="0">
    <form action="/user?action=add" method="post" >
        <%--<tr>--%>
            <%--<td>账&nbsp;&nbsp;号</td>--%>
            <%--<td>--%>
                <%--<input type="text" id="userid" name="userid">--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" id="username" name="username">
            </td>
        </tr>
        <br>
        <tr>
            <td>密&nbsp;&nbsp;码</td>
            <td>
                <input type="password" id="userpassword" name="userpassword">
            </td>
        </tr>
        <br>
        <tr>
            <td>确认密码</td>
            <td>
                <input type="password" id="userpassword1" name="userpassword1" onblur="check(this)">
            </td>
        </tr>
        <br>
        <tr><td>验证码<td>
                <span  id="code" >
                     <script>
                              num=checkcode();
                              document.write(num);
                      </script>
                </span>
            <input type="text" name="yzm"  size="10" id="k" onblur="scanfin()">
            <input type="button" value="看不清" onclick="product()" >
        </td>
        </tr>
        <br>
        <tr>
            <td>
                <input type="submit" value="确认" onclick="submit()">
            </td>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </form>
</table>

</body>
</html>
