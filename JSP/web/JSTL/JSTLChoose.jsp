<%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/4
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose</title>
</head>
<body>
   <%-- 完成数字编号对应星期几案例：
        1、域中存储一个数字
        2、使用choose标签去除数字              相当于swich声明
        3、使用when标签做数字判断              相当于case
        4、otherwise标签做其他情况的声明       相当于default--%>
        <%
            request.setAttribute("num",1);
        %>
      <c:choose>
          <c:when test="${ num == 1 }">星期一</c:when>
          <c:when test="${ num == 1 }">星期二</c:when>
          <c:when test="${ num == 1 }">星期三</c:when>
          <c:when test="${ num == 1 }">星期四</c:when>
          <c:when test="${ num == 1 }">星期五</c:when>
          <c:when test="${ num == 1 }">星期六</c:when>
          <c:when test="${ num == 1 }">星期天</c:when>
          <c:otherwise>输入有误</c:otherwise>
      </c:choose>
</body>
</html>
