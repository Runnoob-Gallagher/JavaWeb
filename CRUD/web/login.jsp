<%--
  Created by IntelliJ IDEA.
  User: yangjz
  Date: 2020/9/10
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!--initial-scale 表示缩放比例-->
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script type="text/javascript">
        function refreshCode() {
            //获取验证码对象
            var elementById = document.getElementById("changecode");
            //修改验证码图片src路径
            elementById.src = "${pageContext.request.contextPath}/checkCodeServlet?time=" + new Date().getTime();
        }
</script>
</head>
<body>
<h3 style="text-align: center">
    管理员登录
</h3>
<div class="container" style="width: 400px">
    <form action="${pageContext.request.contestPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="name">用户名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="name" placeholder="请输入密码">
        </div>
        <div class="form-inline">
            <div class="form-group">
                <label for="changecode">验证码：</label>
                <input type="text" class="form-control" name="verifycode" id="checkcode" placeholder="验证码输入" style="width: 150px">
                <a href="javascript:refreshCode();">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="changecode"/>
                </a>
            </div>
        </div>
        <hr>
        <div style="text-align: center" class="login">
            <button type="button" class="btn btn-primary">登录</button>
        </div>
    </form>
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>登录失败!</strong>
    </div>
</div>

</body>
</html>