<%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/3
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>successlogin</title>
</head>
<body>
<h1><%= request.getSession().getAttribute("user")%>,欢迎你</h1>
</body>
</html>
