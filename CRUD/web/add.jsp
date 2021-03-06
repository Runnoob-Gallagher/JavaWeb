<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!--initial-scale 表示缩放比例-->
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加信息</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->

</head>
<body>
    <div>
        <h3 style="text-align: center">
            添加地区版本信息
        </h3>
    </div>
    <div class="container">
        <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName">姓名</label>
                <input type="text" class="form-control" id="exampleInputName" name="XM" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label>性别</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>
            <div class="form-group">
                <label for="exampleInputAge">年龄</label>
                <input type="text" class="form-control" id="exampleInputAge" name="age" placeholder="请输入年龄">
            </div>
            <div class="form-group">
                <label for="exampleInputPlace">籍贯: </label>
                <select  class="form-control" id="exampleInputPlace" name="address" >
                    <option value="陕西">陕西</option>
                    <option value="北京">北京</option>
                    <option value="上海">上海</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleInputQQ">QQ</label>
                <input type="text" class="form-control" id="exampleInputQQ" name="qq" placeholder="请输入QQ号">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail">Email</label>
                <input type="text" class="form-control" id="exampleInputEmail" name="email" placeholder="请输入邮箱">
            </div>
            <div style="text-align: center">
                <button type="submit" class="btn btn-primary">提交</button>
                <button type="submit" class="btn btn-default">重置</button>
                <button type="submit" class="btn btn-default">返回</button>
            </div>

        </form>
    </div>

</body>
</html>