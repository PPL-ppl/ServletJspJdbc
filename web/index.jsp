<%--
  Created by IntelliJ IDEA.
  User: 19424
  Date: 2020/9/7
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>学生管理</h1>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>注册日期</th>
        <c:forEach items="${list}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.score}</td>
        <td>${student.birthday}</td>
        <td>
            <a href="/student?method=deleteById&id=${student.id}">删除</a>
            <a href="/student?method=findById&id=${student.id}">修改</a>
        </td>
    </tr>

    </c:forEach>
    </tr>
</table>
</body>
</html>
