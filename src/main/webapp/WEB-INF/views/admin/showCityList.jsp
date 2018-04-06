<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 上午 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理城市列表</title>
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
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>
    <div style="width: 40%;margin-right: auto;margin-left: auto;">
        <input type="button" value="添加城市" onclick="OpenDiv1()"/>
        <form>
        <table class="table" >
            <tr><th>城市名称</th><th>操作</th></tr>
                 <c:forEach items="${cityList}" var="city">
                    <tr><td>${city.name}</td><td><a href="/city/delete?id=${city.id}">删除</a> </td></tr>
                </c:forEach>
        </table>
        </form>
    </div>
    <div id="div1">
        <form id="addApply" action="/city/addCity" >
        请输入城市名称:<input name="name" type="text"/></br>
        <input type="submit" name="submit" value="确认"/></br>
        <input type="button" name="cancel" value="取消" onclick="CloseDiv1()"/>
        </form>



    </div>
</div>
</body>
</html>
