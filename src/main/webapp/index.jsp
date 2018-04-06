<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<script>
    
</script>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>

<div style="width: 40%;margin-right: auto;margin-left: auto;">
<form id="form" action="/user/login.do">
    <table  class="contentTb table">
        <tr><td></td><td></td></tr>
        <tr><td>email</td><td><input type="text" name="email" value=""/></td></tr>
        <tr><td>password</td><td><input type="password" name="password" value=""/></td></tr>
        <tr><td></td><td ><input type="submit" name="submit" value="登录"/></td></tr>
        <tr><td>没有账号?</td><td><a href="/user/register">注册</a>|<a href="/CamLecture/selectCom.do">游客</a></td></tr>
        <tr><td></td><td><a href="/user/toAdminLogin">管理员登录</a> </td></tr>
    </table>
</form>

</div>
</div>
</body>
</html>