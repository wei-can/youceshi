<%--
  Created by IntelliJ IDEA.
  User: 魏灿
  Date: 2020/11/24
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fm:form modelAttribute="user" action="${pageContext.request.contextPath }/test/useraddtest">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <fm:input path="userCode"/><fm:errors path="userCode"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <fm:input path="userPassword"/><fm:errors path="userPassword"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</fm:form>
<div>
    <form action="${pageContext.request.contextPath }/test/upload" enctype="multipart/form-data" METHOD="post">
        <input type="file" name="file"><input type="submit" value="提交">
    </form>
</div>
</body>
</html>
