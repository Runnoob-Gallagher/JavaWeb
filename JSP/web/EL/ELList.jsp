<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="EL.ELObject" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/4
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取List集合</title>
</head>
<body>
<h3>获取List集合中的东西</h3>
<%
    ELObject eoj = new ELObject();
    eoj.setAge(24);
    eoj.setBirthday(new Date());
    eoj.setName("Gallagher");
    List list = new ArrayList();
    list.add("Gallagher");
    list.add("Runnoob");
    list.add(eoj);
    request.setAttribute("List",list);
    request.setAttribute("user",eoj);
%>

    <%--${域名称.键名[索引]}--%>
    ${
    requestScope.List
    }<br/>
    ${
    requestScope.user.name
    }<br/>
    ${
    requestScope.List[0]
    }</br>
    ${
    List[1]
     }<br/>
    ${
    requestScope.List[5]
    }<br/>  <%--当角标越界时不会报错，只是补一个空字符串--%>
<h3>important</h3>
    ${
    List[2].name
    }
<%--    eoj.setAge(24);
            eoj.setBirthday(new Date());
            eoj.setName("Gallagher"); //之前没写这部分，就是没有获取到对应的值，因为EL就直接返回空字符串，就识别不了--%>
</body>
</html>
