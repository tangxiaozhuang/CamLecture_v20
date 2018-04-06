<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/8
  Time: 下午 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增应聘记录</title>
    <script>
        function show_sub(v){
            if(v==0){
                document.getElementById("otherCompany").style.display="block";
            }else {
                document.getElementById("otherCompany").style.display="none";
            }
        }
    </script>
    <style>
        .addAppContent{
            width: 50%;
            margin-left:auto;
            margin-right:auto;
        }
    </style>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
    <div class="addAppContent">
<form action="/ApplyProgress/addApply.do">
    <table width="40%" class="table contentTb">
        <tr><td>Title</td><td>：<input type="text" name="applyTitle"/></td></tr></br>
        <tr><td>岗位</td><td>：<input type="text" name="applyPosition"/></td></tr></br>
        <tr><td>公司</td><td>：<select name="company" onchange="show_sub(this.options[this.options.selectedIndex].value)">
        <option value="0" >其他</option>
        <c:forEach items="${comList}" var="company">
            <option value="${company.id}:${company.comName}" >
                ${company.comName}
            </option>
        </c:forEach>
        </select><input type="text" name="otherCompany" id="otherCompany" style="display:block" value="请输入公司名称"/></td></tr>

        <tr><td>进度</td><td>：<select name="progress">
        <option value=1>宣讲会</option>
        <option value=2>网申/初面</option>
        <option value=3>笔试</option>
        <option value=4>面试</option>
        <option value=5>offer</option>
        <option value=6>签约</option>
        </select></td></tr></br>
        <tr><td></td><td> &nbsp;&nbsp;<input type="submit" name="submit" value="提交"/></td></tr>

    </table>
</form>

    </div>
</div>
</body>
</html>
