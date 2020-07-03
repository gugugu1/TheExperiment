<%@ page import="com.bojcet.vo.user" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bojcet.vo.usinguser" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10 0010
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>客户管理系统</title>
    <script type="text/javascript">
        // function checkAll(allC){
        //     var otherCs=document.getElementsByName("delId")
        //     for(var i=0;i<otherCs.length;i++){
        //         otherCs[i].checked=allC.checked;
        //     }
        // }
    </script>
</head>
<body background="img/manage1.jpg">
<div align="center">
    <h1 align="center">管理员[<%
        user user1=new user();
        user1.setUsername(request.getParameter("username"));
        String name=user1.getUsername();
    %>
        <tr>
            <td><%=name%></td>
        </tr>

        ]，欢迎使用客户管理系统</h1>
    <h2 align="left">
        <a href="user?action=logout">退出登录</a> </h2>
    <h2>客户列表页面</h2><hr>

    <form action="" method="post">
        <%--<input type="submit" value="删除选中项"/>--%>
        &nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="add.jsp">添加客户</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="query.jsp">查询客户信息</a>
        <br>
        <table border="2" >
            <tr>

                <th width="100" >客户ID</th>
                <th width="100">客户姓名</th>
                <th width="80">客户密码</th>
                <%--<th>出生日期</th>--%>
                <th width="120">手机号码</th>
                <th width="120">电子邮件</th>
                <%--<th>客户爱好</th>--%>
                <%--<th>客户类型</th>--%>
                <th width="120">个人描述</th>
                <th width="80">修改</th>
                <th width="80">删除</th>
            </tr>
            <%--<c:forEach items="${requestScope.list }" var="cust">--%>
            <%
                List<usinguser> list=(List<usinguser>)request.getAttribute("list");
                if(list!=null){
                    usinguser usinguser=new usinguser();
                    for(int i=0;i<list.size();i++){
                        usinguser=list.get(i);
            %>
                <tr>
                    <%--<td><input type="checkbox" name="delId" value="${cust.id }"/></td>--%>
                    <td><%=usinguser.getUsingid()%></td>
                    <td><%=usinguser.getUsingname()%></td>
                    <td><%=usinguser.getUsingpassword()%></td>
                    <td><%=usinguser.getUsingphone()%></td>
                    <td><%=usinguser.getUsingemail()%></td>
                    <td><%=usinguser.getUsingdescribe()%></td>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <td><a href="/usinguser?action=tiao&usingid=<%=usinguser.getUsingid()%>">修改</a></td>
                    <td><a href="/usinguser?action=del&usingid=<%=usinguser.getUsingid()%>">删除</a></td>
                </tr>
            <%--</c:forEach>--%>
            <%
                    }
                }
            %>

        </table>

    </form>
</div>
</body>

</html>
