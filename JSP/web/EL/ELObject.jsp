<%@ page import="EL.ELObject" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/9/4
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象数据</title>
</head>
<body>

    <%
        ELObject eoj = new ELObject();
        eoj.setAge(24);
        eoj.setBirthday(new Date());
        eoj.setName("Gallagher");
        //将对象存储到request域中
        request.setAttribute("user",eoj);
    %>
    <h3>获取对象中的值</h3>
    ${requestScope.user} </br> <%-- EL.ELObject@13319e30--%>
   <%-- 通过对象的属性类获取：
        *setter或者getter方法，去掉set或get将首字母小写，剩下的东西就称为属性
            比如  setName  --->  name--%>
    ${requestScope.user.name}<br>
    ${user.age}<br>
    ${user.birthday}<br>
    ${user.birthday.month}   <%--这里其实就相当于调用getAge、getBirthday、getName方法,这样我们就创建日期格式化方法--%>
    ${user.dsf}  <%--这一点很重要，怎么是dsf的。要考虑上面写的属性！！！！！！！！--%>
</body>
</html>
