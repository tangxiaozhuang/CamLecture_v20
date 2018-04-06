<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/8
  Time: 下午 6:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增宣讲会信息</title>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="body">
    <%@include file="/WEB-INF/include/headAdmin.jsp"%>

<div style="width: 60%;margin-left: auto;margin-right: auto;">
    <form id="addCam" method=”post” action="/CamLecture/addCam.do">
        <table class="table">
            <tr><td>宣讲会主题：</td><td><input type="text" name="theme"/></td></tr></br>
            <tr><td>公司名称：</td><td><select name="companyId">
                    <c:forEach items="${comList}" var="company">
                        <option value=${company.id}>${company.comName}</option>
                    </c:forEach>
        </select></td></tr></br>
            <tr><td>宣讲会简介：</td><td><textarea name="content" style="width:200px;height:80px;"></textarea></td></tr></br>
            <tr><td>宣讲会地址：</td><td><input type="text" name="address"/></td></tr></br>
            <tr><td>举办时间:</td><td>
                <input name="camDate1"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" /></td></tr>
            <tr><td>举办城市：</td><td><select name="city">
                        <c:forEach items="${cityList}" var="city">
                            <option value=${city.id}>${city.name}</option>
                        </c:forEach>
            </select></td></tr></br>
            <tr><td>职位：</td><td><textarea name="position" style="width:200px;height:50px;"></textarea></td></tr></br>
         <%--<input type="button" name="sub" onclick="subForm()" value="提交"/>--%>
            <tr><td></td><td><input type="submit" name="submit" value="提交"/></td></tr>
        </table>
    </form>
</div>
</div>
</body>
</html>
