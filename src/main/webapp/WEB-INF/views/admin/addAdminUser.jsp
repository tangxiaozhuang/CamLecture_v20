<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/13
  Time: 下午 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>
<div style="width: 40%;margin-left: auto;margin-right: auto">
    <form id="addAdmin" action="/user/addAdminUser">
    <table class="table">
        <tr><td></td><td>${message}</td></tr>
        <tr><td>管理员名称：</td><td><input type="text" name="username"/></td></tr>
        <tr><td>管理员邮箱：</td><td><input type="text" name="email"/></td></tr>
        <tr><td>管理员密码：</td><td><input type="text" name="password"/></td></tr>
        <tr><td></td><td><input type="submit" name="submit" value="添加"/></td></tr>
    </table>
    </form>
</div>
</div>
</body>
</html>
