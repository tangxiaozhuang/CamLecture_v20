<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<script>

</script>
<style>
    .showCam{
        width: 80%;
        margin-left:auto;
        margin-right:auto;
    }
</style>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/head.jsp"%>
<span style="font-size:20px;">宣讲会列表</span>
    <div class="showCam">
<table width="80%" class="table table-bordered table-striped">
    <thead>
    <tr><th>主题</th><th>企业</th><th>地址</th><th>时间</th><th>查看详情</th></tr>
    </thead>
    <tbody class="text-left">
    <c:forEach items="${camList}" var="camLecture">
        <tr>
            <td>${camLecture.theme}</td>
            <td>
            <c:forEach items="${comList}" var="company">
                <c:if test="${company.id==camLecture.companyId}">
                    ${company.comName}
                </c:if>
            </c:forEach>

            </td>
            <td>${camLecture.address}</td>
            <td><fmt:formatDate value="${camLecture.camDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

            <td>
                <a href="/CamLecture/showDetails?id=${camLecture.id}&theme=${camLecture.theme}&address=${camLecture.address}&city=${camLecture.city}&content=${camLecture.content}&position=${camLecture.position}&camDate=${camLecture.camDate}&ref1=${camLecture.ref1}&companyId=${camLecture.companyId}">详细</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>
</body>
</html>