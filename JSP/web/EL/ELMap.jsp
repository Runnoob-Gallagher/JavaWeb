<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="EL.ELObject" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/4
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取Map集合</title>
</head>
<body>
    <%
        Map map = new HashMap();
        ELObject eoj = new ELObject();
        eoj.setAge(24);
        eoj.setBirthday(new Date());
        eoj.setName("Runnoob");
        map.put("name","Gallagher");
        map.put("gender","男");
        map.put("object",eoj);
        request.setAttribute("map_name",map);
    %>
  <%--  ${域名称.键名.key名称}
    ${域名称.键名["key名称"]}--%>

    ${
        requestScope.map_name.name
    }<br/>
    ${
        requestScope.map_name.object.name
    }<br/>
    ${
        requestScope.map_name["gender"]
    }<br/>
    ${
        requestScope.map_name["object"].age
    }
</body>
</html>
