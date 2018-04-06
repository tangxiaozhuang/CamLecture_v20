<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/9
  Time: 上午 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑宣讲会信息</title>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>

</head>
<br>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>

<div style="margin-left: auto;margin-right: auto;width: 60%">
    <form action="/CamLecture/updateCamAdmin">
        <table class="table">
            <input type="hidden" name="id" value="${camLecture.id}"></br>
            <tr><td>宣讲会主题</td><td>：<input type="text" name="theme" value="${camLecture.theme}"/></td></tr></br>
            <tr><td>宣讲会简介</td><td>：<textarea  name="content" value="${camLecture.content}">${camLecture.content}</textarea></td></tr></br>
            <tr><td>开办企业 </td><td>： <select name="companyId">
                <c:forEach items="${comList}" var="company">
                    <c:if test="${camLecture.companyId==company.id}">
                        <option value="${company.id}" selected="selected">${company.comName}</option>
                    </c:if>
                    <c:if test="${camLecture.companyId!=company.id}">
                        <option value="${company.id}">${company.comName}</option>
                    </c:if>
                </c:forEach>

            </select>
            </td></tr>
        </br>
            <tr><td>宣讲会地址</td><td>：<input type="text" name="address" value="${camLecture.address}"/></td></tr></br>
            <tr><td>举办时间</td><td>：<input name="camDate1" value="<fmt:formatDate value="${camLecture.camDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" ></td></tr></br>
            <tr><td>所在城市</td><td>：<select name="city">
                <c:forEach items="${cityList}" var="city">
                    <c:if test="${camLecture.city==city.id}">
                        <option value="${city.id}" selected="selected">${city.name}</option>
                    </c:if>
                    <c:if test="${camLecture.city!=city.id}">
                        <option value="${city.id}">${city.name}</option>
                    </c:if>
                </c:forEach>
            </select></td></tr></br>
            <tr><td>职位</td><td>：<input type="text" name="address" value="${camLecture.address}"/></td></tr></br>
            <tr><td></td><td>&nbsp;<input type="submit" name="submit" value="提交"/></td></tr></br>
        </table>
    </form>
</div>
</div>
</body>
</html>
