<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/17
  Time: 下午 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="jquery-3.3.1.js"></script>
<body>

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
                    <a class="navbar-brand" href="#">管理员</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class=""><a href="/CamLecture/getAllAdmin">宣讲会信息</a></li>
                        <li><a href="/Company/showComListAdmin">企业信息</a></li>
                        <li><a href="/city/showCity">城市信息</a></li>
                        <li><a href="/user/addAdminUser" data-toggle="modal" data-target="#about-modal">用户管理</a></li>
                    </ul>
                </div>

            </div>
        </nav>
    </div>

</body>
</html>