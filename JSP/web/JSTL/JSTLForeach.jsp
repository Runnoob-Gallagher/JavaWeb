<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/4
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Foreach标签</title>
       <%-- foreach:相当于java代码的for语句
            1.完成重复的操作
                for(int i=0; i< 10l i++){
    }
            *属性：
                begin：开始值
                end：结束值
                var：临时变量
                step：步长
                varStatus：循环状态对象
                    index:容器中元素的索引，从0开始
                    count：循环次数，从1开始
            1.遍历容器
                List<User> list;
                for(User user : list){
    }
            *属性：
                items：容器对象
                var：容器中元素的临时变量
                varStatus:循环状态对象
                    index：容器中元素的索引，从0开始
                    count：循环次数，从1开始--%>
</head>
<body>
    <c:forEach begin="1" end="10" step="2" varStatus="s">
        ${i} <h3>${s.index}<h3> <h4> ${s.count} </h4> <br>
    </c:forEach>
        <hr>
            <%
            List list = new ArrayList();
            list.add("aaa");
            list.add("bbb");
            list.add("ccc");
            request.setAttribute("list_name",list);
            %>
        <c:forEach items="${list_name}" var="var" varStatus="s">
                ${s.index} ${s.count} ${var} <br>
        </c:forEach>
</body>
</html>
