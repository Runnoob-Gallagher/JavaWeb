<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入taglib包--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!--initial-scale 表示缩放比例-->
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>社保费版本查询</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<header class="container">
    <h3 style="text-align: center">社保管理子系统版本查询</h3>
    <table class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${usermessage}" var="user" varStatus="num">
            <%--varStatus:表示循环状态对象  ，类比迭代器--%>
            <tr>
                <td>${num.count}</td>
                <td>${user.XM}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="update.html">修改</a><a class="btn btn-default btn-sm" href="">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <div style="text-align: center">
        <a class="btn btn-primary" style="text-align: center" href="add.html">添加联系人</a>
        <!--<button type="button" class="btn btn-primary">添加联系人</button>-->
    </div>

</header>
</body>
</html>

