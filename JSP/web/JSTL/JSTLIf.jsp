<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/4
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入标签库：taglib指令：<%@ taglib %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL if标签</title>
</head>
<body>
    <%
        Map map = new HashMap();
        map.put("name","Gallagher");
        request.setAttribute("map_name",map);

    %>
    <c:if test="${empty map_name}">
        因为我是true所以你就要打印我。。。
    </c:if>
</body>
</html>
