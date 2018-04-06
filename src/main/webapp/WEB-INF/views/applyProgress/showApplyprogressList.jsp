<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/8
  Time: 下午 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>行程列表</title>
    <script>
        function editApp(id,progress){
            alert(id+"--"+progress);
            window.location.open("/ApplyProgress/updateProgress.do?id="+id);
        }
    </script>
    <style>
        .showAdd{
            width: 80%;
            margin-left:auto;
            margin-right:auto;
        }
    </style>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>

<button ><a href="/ApplyProgress/newApp.do">新增应聘记录</a>
</button>
    <div class="showAdd">
<table width="60%" class="table table-bordered table-striped">
   <thead> <tr><th>Title</th><th>职位</th><th>公司</th><th>进度</th><th>操作</th></tr></thead>
    <tbody>
    <c:forEach items="${appList}" var="applyProgress">
    <c:if test="${applyProgress.progress!=7&&applyProgress.progress!=0}">
    <tr name="${applyProgress.id}" id="${applyProgress.id}">

        <td name="applyTitle" value="${applyProgress.applyTitle}">${applyProgress.applyTitle}</td>

        <td name="applyPosition">${applyProgress.applyPosition}</td>

        <td name="company">${applyProgress.company}</td>
        <td name="progress">
        <c:if test="${applyProgress.progress==1}">宣讲会</c:if>
        <c:if test="${applyProgress.progress==2}">网申/初面</c:if>
        <c:if test="${applyProgress.progress==3}">笔试</c:if>
        <c:if test="${applyProgress.progress==4}">面试</c:if>
        <c:if test="${applyProgress.progress==5}">offer</c:if>
        <c:if test="${applyProgress.progress==6}">签约</c:if>
        </td>
    <td>
            <button name="edit" value=""><a href="/ApplyProgress/updateProgress.do?id=${applyProgress.id}&progress=${applyProgress.progress+1}">已进入下一应聘阶段</a></button>
            <button name="edit" value=""><a href="/ApplyProgress/updateProgress.do?id=${applyProgress.id}&progress=0">应聘失败，结束进程</a></button>
    </td>
    </tr>
    </c:if>
</c:forEach>


<c:forEach items="${appList}" var="applyProgress">
    <c:if test="${applyProgress.progress==0||applyProgress.progress==7}">
        <tr name="${applyProgress.id}" id="${applyProgress.id}">
        <td name="applyTitle" value="${applyProgress.applyTitle}">${applyProgress.applyTitle}</td>

        <td name="applyPosition">${applyProgress.applyPosition}</td>

        <td name="company">${applyProgress.company}</td>
        <td name="progress">
        <c:if test="${applyProgress.progress==0}">应聘失败</c:if>
        <c:if test="${applyProgress.progress==7}">应聘成功</c:if>
        </td>
            <td><button name="edit" value="">
                <a href="/ApplyProgress/deleteApp?id=${applyProgress.id}">删除记录</a></button></td>
        </tr>
    </c:if>
</c:forEach>
    </tbody>
</table>
    </div>
</div>
</body>
</html>
