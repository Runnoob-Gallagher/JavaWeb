<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/4
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL运算符</title>
</head>
<body>
<%--http://localhost:8080/JSP/EL/ELCalcu.jsp--%>
    ${3 > 4}
<h3>Empty运算符</h3>
<%
    String strA = "abc";
    request.setAttribute("strA_name",strA);
    String strB = null;
    request.setAttribute("strB_name",strB);
    List list = new ArrayList();
    request.setAttribute("list_name",list);
%>
    ${
    empty strA_name
    }
    ${
        empty strB_name
    }
    ${
        empty list_name
    }
</body>
</html>
