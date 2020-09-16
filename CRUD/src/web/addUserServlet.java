package web;


import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import domain.Table_user;
import org.apache.commons.beanutils.BeanUtils;
import service.Imple.UserServiceImple;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改字符集
        request.setCharacterEncoding("utf-8");
        //获取表单提交上来的数据
        Map<String, String[]> map = request.getParameterMap();
        //创建javabean对象
        Table_user table_user = new Table_user();
        //使用Template绑定
        try {
            BeanUtils.populate(table_user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //转到UserService去执行
        UserService userService = new UserServiceImple();
        userService.add(table_user);
        //添加之后就跳转到userListServlet中去，因为这里没有共享数据就用重定向,因为是直接想展示数据
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
