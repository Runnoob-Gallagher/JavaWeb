package Servlet;

import Dao.UserDao;
import Login.User;
import com.twelvemonkeys.lang.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/servletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
      /*  //2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/
        //获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3创建user对象
        User loginUser = new User();
        //3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Dao里面的login方法
        UserDao daoA = new UserDao();
        User user = daoA.login(loginUser);
        //判断user
        if (user == null){
            //登陆失败,跳转到新的资源中
            request.getRequestDispatcher("/faildServlet").forward(request,response);
        }else{
            //登陆成功,跳转到新的资源中
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
