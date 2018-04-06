<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/16
  Time: 上午 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>

<table>
    <tr>
        <td>用户名</td><td>：${user.username}</td>
        <td>邮箱</td><td>：${user.email}</td>
        <td>学校</td><td>：${user.school}</td>
        <td>城市</td><td>：<c:forEach items="cityList" var="city"><c:if test="${city.id==user.city}">${city.name}</c:if></c:forEach></td>
    </tr>
</table>
<a href="/user/editUser">修改个人信息</a>
</body>
</html>
