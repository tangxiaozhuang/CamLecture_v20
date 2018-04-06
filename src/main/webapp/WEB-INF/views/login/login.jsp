<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6
  Time: 下午 6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
<div style="width:40%;text-align:center;margin-left:auto;margin-right:auto;">
    ${message}
<form id="form" action="/user/login.do">
    <table class="table">
        <tr><td>email</td><td>：<input type="text" name="email" value=""/></td></tr><br/>
        <tr><td>password</td><td>：<input type="password" name="password" value=""/></td></tr><br/>
        <tr><td></td><td>&nbsp<input type="submit" name="submit" value="登录"/></td></tr><br/>
        <tr><td></td><td>&nbsp</td></tr>
        <tr><td>没有账号</td><td>：<a href="/user/register">注册新账号</a> </td></tr>
    </table>
</form>
</div>

</div>
</body>
</html>
