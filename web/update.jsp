<%--
  Created by IntelliJ IDEA.
  User: 19424
  Date: 2020/9/7
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student" method="post">
    编号 <input type="text" name="id" value="${student.id}" readonly><br/>
    姓名 <input type="text" name="name" value="${student.name}"><br/>
    成绩 <input type="text" name="score" value="${student.score}"><br/>
    <input type="hidden" name="method" value="update"><%--隐藏--%>
    <input type="submit" value="修改">
</form>
</body>
</html>
