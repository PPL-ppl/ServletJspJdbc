<%--
  Created by IntelliJ IDEA.
  User: 19424
  Date: 2020/9/7
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student" method="post">
    姓名<input type="text" name="name"/><br/>
    成绩<input type="text" name="score"/><br/>
    <input type="hidden" name="method" value="add"><%--隐藏--%>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
