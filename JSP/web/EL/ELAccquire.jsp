<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/4
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>

<%
    //在域中存储数据
    request.setAttribute("name","Gallagher");
    session.setAttribute("age",24);
%>

<h3>从域中获取值</h3>      <%--如果EL没有获取到值，那么他就返回空字符串--%>
${requestScope.name} </br>
${sessionScope.age}


</body>
</html>
