package web;

import dao.Imple.UserdaoImple;
import domain.Table_user;
import org.apache.commons.beanutils.BeanUtils;

import org.junit.Test;
import service.Imple.UserServiceImple;
import service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为是post请求，需设置编码
        request.setCharacterEncoding("utf-8");
        //获取用户输入的验证码,因为用户输入的会存在与请求中，那就就用request去获取
        String verifycode = request.getParameter("verifycode");
        //而程序生成的验证码是存在放在session中，所以要用session去获取
        //获取session
        HttpSession session = request.getSession();
        //获取到程序生成验证码并存储在checkcode中
        String checkcode_value = (String) session.getAttribute("checkcode");
        //因为前面就获取到了且已经取到了值，就可以把验证码存储在Attribute中的值丢弃
        session.removeAttribute("checkcode");
        //判断验证码是否正确
        if (!checkcode_value.equalsIgnoreCase(verifycode)) {
            //错误就发送错误信息
            request.setAttribute("log_msg", "验证码输入错误！！");
            //跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        //获取所有的request对象中的元素(包括username、password、验证码)，并封装在map集合中
        Map<String, String[]> usermsgmap = request.getParameterMap();
        //封装table_user对象
        Table_user table_user = new Table_user();
        //在使用BeanUtils中的populate方法去匹配
        try {
            BeanUtils.populate(table_user, usermsgmap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service对象获取数据库中的username和password
        UserService userService = new UserServiceImple();
        Table_user getuserpass_user = userService.getuserpassword(table_user);
        try {
             getuserpass_user = userService.getuserpassword(table_user);
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("空的");
        }

        if (getuserpass_user != null) {
            //将用户信息存入session中
            session.setAttribute("user", getuserpass_user);
            //跳转界面,因为没有共享数据就直接跳转
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            //提示登录失败信息
            request.setAttribute("log_msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
