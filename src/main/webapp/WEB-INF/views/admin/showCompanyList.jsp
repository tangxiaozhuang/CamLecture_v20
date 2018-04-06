<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/13
  Time: 下午 7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>

<div style="width: 70%;margin-left: auto;margin-right: auto;">
    <a href="/Company/newComAdmin">添加企业信息</a>
<table class="table">
    <tr><th>企业名称</th><th>网申地址</th><th>企业logo</th><th>编辑</th><th>删除</th></tr>
    <c:forEach items="${comList}" var="company">
        <tr>
            <td>${company.comName}</td>
            <td>${company.webSite}</td>
            <td><c:if test="${company.logoImg!=null }">
                <img alt="${company.comName }" src="/file/${company.logoImg}.jpg">
            </c:if></td>
            <td><a href="/Company/editCompany?id=${company.id}&comName=${company.comName}&webSite=${company.webSite}&comIntroduct=${company.comIntroduct}&position=${company.position}">编辑</a> </td>
            <td><a href="/Company/deleteCompany?id=${company.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</div>
</body>
</html>
