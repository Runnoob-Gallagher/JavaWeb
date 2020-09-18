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
    <script>
        function delUser(id) {
            //用户安全提示
            if(confirm("确定删除所选？")){
                //定义访问路径
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }
        window.onload = function () {
            // 给删除选中绑定单击事件,用于提交表单

                document.getElementById("delselected").onclick = function () {
                    if(confirm("确定删除所选？？")){
                    //submit就是提交表单的
                    document.getElementById("form").submit();
                }
            }
        }
            document.getElementById("allselected").onclick = function () {
            //获取下边列表中所有的checkbox
            var checkid = document.getElementsByName("uid");
            //遍历
            for (var i = 0; i <checkid.length ; i++) {
                checkid[i].checked = this.checked;
            }
        }
    </script>
</head>
<body>
<header class="container">
    <h3 style="text-align: center">社保管理子系统版本查询</h3>
    <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post" style="float: left;margin-top: 10px;margin-bottom: 5px" >
        <div class="form-group">
            <label for="InputName">姓名</label>
            <input type="text" name="XM" class="form-control" id="InputName">
        </div>
        <div class="form-group">
        <label for="InputAddr">籍贯</label>
        <input type="text" name="address" class="form-control" id="InputAddr">
        </div>
        <div class="form-group">
            <label for="InputEmail">邮箱</label>
            <input type="email" name="email" class="form-control" id="InputEmail">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
    </form>
    <div style="float: right; margin-top: 10px;margin-bottom: 5px" >
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delselected">删除选中</a>
        <!--<button type="button" class="btn btn-primary">添加联系人</button>-->
    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" method="post">
    <table class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="allselected"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean_list.list}" var="user" varStatus="num">
            <%--varStatus:表示循环状态对象  ，类比迭代器--%>
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${num.count}</td>
                <td>${user.XM}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>
                    <%--<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/delUserServlet?id=${user.id}">删除</a>--%>
                    <a class="btn btn-default btn-sm" href="javascript:delUser(${user.id});" >删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean_list.currentPage == 1}">
                <li class="disabled">
            </c:if>
            <c:if test="${pageBean_list.currentPage !=1 }">
                <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean_list.currentPage-1}&rows=6" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


            <c:forEach begin="1" end="${pageBean_list.totalPage}" var="num">  <%--var的意思是代表每一个的变量--%>
            <c:if test="${pageBean_list.currentPage == num}">
                <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${num}&rows=6">${num}</a></li>
            </c:if>
            <c:if test="${pageBean_list.currentPage != num}">
                <li ><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${num}&rows=6">${num}</a></li>
            </c:if>
            </c:forEach>
                <c:if test="${pageBean_list.currentPage == pageBean_list.totalPage}">
                    <li class="disabled">
                        <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean_list.currentPage}&rows=6" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageBean_list.currentPage != pageBean_list.totalPage}">
                    <li>
                <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pageBean_list.currentPage + 1}&rows=6" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                    </li>
                    </c:if>

            </li>
            <span style="margin-left: 5px;font-size: 25px">
               共${pageBean_list.totalCount}条记录，共${pageBean_list.totalPage}页
            </span>

        </ul>
    </nav>

</header>
</body>
</html>

