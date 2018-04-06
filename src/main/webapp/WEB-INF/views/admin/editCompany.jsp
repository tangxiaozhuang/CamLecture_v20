<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/16
  Time: 上午 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑宣讲会</title>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>
<div style="width: 80%;margin-left: auto;margin-right: auto;">
<form action="/Company/update">
    <input type="hidden" name="id" value="${company.id}">
<table class="table">
    <tr><td>企业名称:</td><td><input name="comName" type="text" value="${company.comName}"/></td></tr>
    <tr><td>招聘官网:</td><td><input name="webSite" type="text" value="${company.webSite}" /></td></tr>
    <tr><td>企业介绍:</td><td><textarea style="width: 300px;height:250px;" name="comIntroduct">${company.comIntroduct}</textarea></td></tr>
    <tr><td>职位介绍:</td><td><textarea style="width: 300px;height:250px;" name="position">${company.position}</textarea></td></tr>
    <tr><td></td><td>&nbsp<input type="submit" name="submit" value="提交"></td></tr>
</table>
</form>
</div>
</div>
</body>
</html>
