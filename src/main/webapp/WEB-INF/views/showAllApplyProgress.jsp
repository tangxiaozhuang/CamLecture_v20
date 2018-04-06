<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/7
  Time: 下午 4:29
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
<table>
    <c:forEach items="${appList}" var="applyProgress">
        <tr>
            <td>${applyProgress.applyTitle}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
