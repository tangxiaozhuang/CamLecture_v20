<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6
  Time: 下午 5:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        .regist{
            width: 40%;
            margin-left:auto;
            margin-right:auto;
        }
    </style>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
${message}
    <div class="regist">
<form id="form" action="/user/insert.do">

    <table class="table">
        <tr><td>邮箱</td><td><input name="email" type="text" id="email" value=""/></td></tr><br/>
        <tr><td>密码</td><td><input name="password" type="password" id="password" value=""/></td></tr><br/>
        <tr><td>用户名</td><td><input name="username" type="text" id="username" value=""/></td></tr>
        <tr><td>学校</td><td><input name="school" type="text" id="school" value=""/></td></tr><br/>
        <tr><td>城市</td><td><select class="form-control" id="city" name="city">
            <c:forEach items="${cityList}" var="city">
                <option value="${city.id}">${city.name}
                </option>
            </c:forEach>
        </select></td></tr><br/>
        <tr><td></td><td>&nbsp;<input type="submit" value="提交" name="submit"/></td></tr><br/>
        <tr><td>已经有账号</td><td><a href="/user/redLogin"> 直接登录</a> </td></tr><br/>
    </table>
</form>
    </div>
</div>
</body>
</html>
