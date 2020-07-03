<%@ page import="com.bojcet.vo.usinguser" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10 0010
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理系统_查询客户信息</title>
</head>
<body background="img/query.jpg">

    <form action="/usinguser?action=select" method="post">
        <center>
            <h1>客户管理系统_查询客户信息</h1><hr>
            <input type="text" id="query" name="query" value="请输入用户ID">
            <input type="submit" value="查询">
            &nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="add.jsp">添加客户</a>

        <%--<a href="query.jsp">查询客户信息</a>--%>
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

                <td><%=usinguser.getUsingid()%></td>
                <td><%=usinguser.getUsingname()%></td>
                <td><%=usinguser.getUsingpassword()%></td>
                <td><%=usinguser.getUsingphone()%></td>
                <td><%=usinguser.getUsingemail()%></td>
                <td><%=usinguser.getUsingdescribe()%></td>
                <%--<td></td>--%>
                <%--<td></td>--%>
                <td><a href="/usinguser?action=tiao&usingid=<%=usinguser.getUsingid()%>">修改</a></td>
                <td><a href="/usinguser?action=del&usingid=<%=usinguser.getUsingid()%>"><%

                %>删除</a></td>
            </tr>
            <%--</c:forEach>--%>
            <%
                    }
                }
            %>

        </table>
        </center>
    </form>
</body>
</html>
