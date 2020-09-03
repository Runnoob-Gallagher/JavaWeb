<%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/3
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script>
        window.onload = function () {
            var ById = document.getElementById("img");
            ById.onclick = function () {
                var date = new Date().getTime();
                ById.src="/CS/CheckCode?" + date;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/CS/LoginServlet" method="post">      <%--因为你这里是有提交的，所以就要用form表单,action指定提交到的地方，method指定的提交方式--%>
    <table align="center">
        <tr>
            <td>
                用户名
            </td>
            <td>
            <input type="text" name="username" placeholder="请输入用户名">
            </td>
        </tr>
        <tr>
            <td>
                密码
            </td>
            <td>
             <input type="password" name="password" placeholder="请输入密码">
            </td>
        </tr>
        <tr>
            <td>
                验证码
            </td>
            <td>
               <input type="text" name="checkCode">
            </td>
        </tr>
        <tr>
            <td colspan="2">
               <img id="img" src="/CS/CheckCode">
            </td>
        </tr>
        <tr>
            <td colspan="2">
               <input type="submit" value="登录">
            </td>
        </tr>
    </table>
    </form>
<div>
    <%= request.getAttribute("check_err_msg") == null ? "" : request.getAttribute("check_err_msg") %>
</div>
<div>
    <%= request.getAttribute("login_err_msg") == null ? "" : request.getAttribute("login_err_msg")%>
</div>
</body>
</html>
