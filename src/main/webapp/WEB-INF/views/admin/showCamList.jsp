<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>宣讲会列表管理</title>
</head>
<script>

</script>
<style>
    .adminCamContent{
        width: 90%;
        margin-left: auto;
        margin-right: auto;
    }
</style>

<body>
<div id="body">
<%@include file="/WEB-INF/include/headAdmin.jsp"%>
<div class="adminCamContent">
<table class="table text-left">
    <tr><td><span>宣讲会列表</span></td><td><button class="button" type="button"><a href="/CamLecture/newCamAdmin">添加宣讲会信息</a></button> </td></tr>
</table>
<table class="table">
    <c:forEach items="${camList}" var="camLecture">
        <tr>
            <td>${camLecture.theme}</td>
            <td>${camLecture.address}</td>
            <td><c:forEach items="${cityList}" var="city">
                <c:if test=" ${camLecture.city==city.id}">
                    ${city.name}
                </c:if>
            </c:forEach></td>
            <td><fmt:formatDate value="${camLecture.camDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>
                <c:forEach items="${comList}" var="company">
                <c:if test="${camLecture.companyId==company.id}">
                    ${company.comName}
                </c:if>
                </c:forEach>
            </td>
            <td>
                <a href="/CamLecture/editCamAdmin?id=${camLecture.id}&theme=${camLecture.theme}&address=${camLecture.address}&city=${camLecture.city}&content=${camLecture.content}&position=${camLecture.position}&camDate=${camLecture.camDate}&ref1=${camLecture.ref1}&companyId=${camLecture.companyId}">编辑</a>
            </td>
            <td>
                <a href="/CamLecture/deleteCamAdmin?id=${camLecture.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
${message}
</div>
</div>
</body>
</html>