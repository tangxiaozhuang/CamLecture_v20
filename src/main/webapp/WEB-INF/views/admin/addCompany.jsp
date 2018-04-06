<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 下午 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加公司</title>

</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>
${message}
<div style="margin-right: auto;margin-left: auto;width: 60%">
    <table class="table">
    <form id="addCompany" action="/Company/addComAdmin">
        <tr><td>企业名称：</td><td><input type="text" name="comName" value=""/></td></tr></br>
        <tr><td>招聘网站：</td><td><input type="text" name="webSite" value=""/></td></tr></br>
        <tr><td>企业简介：</td><td><textarea style="width: 300px;height:100px;" name="comIntroduct"></textarea></td></tr></br>
        <tr><td>企业职位：</td><td><textarea style="width: 300px;height:100px;" name="position"> </textarea></td></tr></form></br>
        <tr><td></td><td>&nbsp;<input type="submit" name="submit" value="提交"/></td></tr>
    </form>
    </table>
</div>
</div>
</body>
</html>
