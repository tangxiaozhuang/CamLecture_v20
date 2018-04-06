<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link rel="stylesheet" href="../js/include/test.css" type="text/css">
    <link href="../js/include/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <style>

    </style>
    <script src="../js/include/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../js/include/jquery-3.3.1.js"></script>
</head>

<body >
<div id="headBody">
    <div id="head">
        <span class="span">宣讲会管理系统</span>
    </div>
    <nav class="navbar navbar-default " role="navigation">
        <div class="container" >
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <span class="navbar-brand" >
                    <c:if test="${user==null||user.id==0}">
                    请<a href="/user/redLogin">登录</a>|<a href="/user/register">注册</a>
                    </c:if>
                        <c:if test="${user!=null&&user.id!=0}">欢迎您：${user.username}</c:if>
                </span>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-center">
                    <li class="active"><a href="/CamLecture/selectCom.do">宣讲会信息</a></li>
                    <li><a href="/ApplyProgress/showAppList.do">应聘行程</a></li>
                    <li><a href="">招聘企业</a></li>
                    <li><a href="" data-toggle="modal" data-target="#about-modal">个人中心</a></li>
                </ul>
</div>
    </nav>
</div>
</body>
</html>
