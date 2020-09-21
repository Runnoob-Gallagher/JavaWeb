<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/20
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/test" method="get">
        用户名：<input type="text" name="username"> </br>
        密码：<input type="password" name="password">
        爱好：<input type="checkbox" name="hobbies" value="nv">女孩
            <input type="checkbox" name="hobbies" value="daima">代码
            <input type="checkbox" name="hobbies" value="youxi">游戏
            <input type="checkbox" name="hobbies" value="qq">QQ
        提交：<input type="submit">
    </form>
</body>
</html>
