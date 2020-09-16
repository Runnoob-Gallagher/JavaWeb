<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!--initial-scale 表示缩放比例-->
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="../js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->

</head>
<body>
    <h3 style="text-align: center">
        修改版本信息
    </h3>
    <div class="container" style="width: 400px">
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
            <!--隐藏域，用于提交id-->
        <input type="hidden" name="id" value="${find_table_user.id}">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" value="${find_table_user.XM}" readonly="readonly" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label >性别：</label>
            <c:if test="${find_table_user.gender == '男'}">
                <input type="radio" sex="sex" value="男" checked="checked"/>男
                <input type="radio" sex="sex" value="女"/>女
            </c:if>
            <c:if test="${find_table_user.gender == '女'}">
                <input type="radio" sex="sex" value="男" />男
                <input type="radio" sex="sex" value="女" checked="checked" />女
            </c:if>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="${find_table_user.age}" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="jiguan">籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <c:if test="${find_table_user.address == '广东'}">
                    <option value="广东" selected>广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南">湖南</option>
                </c:if>

                <c:if test="${find_table_user.address == '广西'}">
                    <option value="广东" >广东</option>
                    <option value="广西" selected="selected">广西</option>
                    <option value="湖南">湖南</option>
                </c:if>

                <c:if test="${find_table_user.address == '湖南'}">
                    <option value="广东" >广东</option>
                    <option value="广西">广西</option>
                    <option value="湖南" selected="selected">湖南</option>
                </c:if>

            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" value="${find_table_user.qq}" id="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email" >Email：</label>
            <input type="text" class="form-control" name="email" value="${find_table_user.email}" id="email" placeholder="请输入邮箱地址"/>
        </div>
        <div style="text-align: center">
            <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </form>
    </div>
</body>
</html>