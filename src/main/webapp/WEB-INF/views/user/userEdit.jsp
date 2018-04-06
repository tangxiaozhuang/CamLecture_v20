<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/16
  Time: 上午 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<form>
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="hidden" name="regTime" value="${user.regTime}"/>
    <input type="hidden" name="status" value="${user.status}"/>
<table>
    <tr>
        <td>用户名</td><td>：<input type="text" name="username" value="${user.username}"/> </td>
        <td>邮箱</td><td>：<input type="text" name="email" value="${user.email}"/> </td>
        <td>学校</td><td>：<input type="text" name="school" value="${user.school}"/></td>
        <td>城市</td><td>：<select name="city">
        <c:forEach items="${cityList}" var="city">
            <c:if test="${city.id==user.city}">
                <option selected="selected">${city.name}</option>
            </c:if>
            <c:if test="${city.id!=user.city}">
                <option >${city.name}</option>
            </c:if>
        </c:forEach>

    </select></td>

    </tr>
</table>
</form>

</body>
</html>
