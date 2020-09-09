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
    <form class="form-inline" style="float: left;margin-top: 10px;margin-bottom: 5px" >
        <div class="form-group">
            <label for="InputName">姓名</label>
            <input type="text" class="form-control" id="InputName">
        </div>
        <div class="form-group">
        <label for="InputAddr">籍贯</label>
        <input type="text" class="form-control" id="InputAddr">
        </div>
        <div class="form-group">
            <label for="InputEmail">邮箱</label>
            <input type="email" class="form-control" id="InputEmail">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
    <div style="float: right; margin-top: 10px;margin-bottom: 5px" >
        <a class="btn btn-primary" href="add.html">添加联系人</a>
        <a class="btn btn-primary" href="add.html">删除选中</a>
        <!--<button type="button" class="btn btn-primary">添加联系人</button>-->
    </div>
    <table class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox"></th>
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
                <th><input type="checkbox"></th>
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
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <span style="margin-left: 5px;font-size: 25px">
               共20条记录，共4页
            </span>

        </ul>
    </nav>

</header>
</body>
</html>

