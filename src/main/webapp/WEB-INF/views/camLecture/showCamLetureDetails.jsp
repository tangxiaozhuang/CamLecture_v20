<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/8
  Time: 上午 1:10
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>宣讲会详情</title>
    <style>
        #div1{

            display: none;

            position: absolute;

            left:50%;

            top:50%;

            width:250px;

            height:150px;

            background-color:gray;

            text-align: center;

        }
    </style>

<script>
    function CloseDiv1(){

    document.getElementById("div1").style.display="none";

    }
    function OpenDiv1(){

        document.getElementById("div1").style.display="block";

    }

</script>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
${result}
<div>

    <table>
        <tr><td>企业名称：</td><td><c:forEach items=""></c:forEach></td></tr>
    </table>

<table class="">
    <tr id="${camLecture.id}">
        <td name="theme">${camLecture.theme}</td>
        <td name="content">${camLecture.content}</td>
        <td naem="address">${camLecture.address}</td>
        <td name="camDate"><fmt:formatDate value="${camLecture.camDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td name="position">${camLecture.position}</td>
        <td name="city">
            <c:if test=" ${camLecture.city}==1">
                广州
            </c:if>
            <c:if test=" ${camLecture.city}==2">
                深圳
            </c:if>
        </td>
    </tr>
</table>

<input type="button" onclick="OpenDiv1()" value="添加到我的行程"/>
</div>

<div id="div1">
    <form id="addApply" action="/ApplyProgress/addApply.do" >
请输入职位:<input name="applyPosition" type="text"/>
    <input type="hidden" name="applyTitle" value="${camLecture.theme}"/>
    <input type="hidden" name="companyId" value="${camLecture.companyId}"/>
    <input type="submit" name="submit" value="确认"/>
    <input type="button" name="cancel" value="取消" onclick="CloseDiv1()"/>
    </form>
</div>
</div>
</body>
</html>
