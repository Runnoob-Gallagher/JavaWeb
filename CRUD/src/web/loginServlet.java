package web;

import dao.Imple.UserdaoImple;
import domain.Table_user;
import org.apache.commons.beanutils.BeanUtils;
<<<<<<< HEAD
import service.Imple.UserServiceImple;
import service.UserService;
=======
>>>>>>> 2bf04086b7a5cfcb6c2b3324a0c83fc76882216c

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 2bf04086b7a5cfcb6c2b3324a0c83fc76882216c
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为是post请求，需设置编码
        request.setCharacterEncoding("utf-8");
        //获取用户输入的验证码,因为用户输入的会存在与请求中，那就就用request去获取
        String verifucode = request.getParameter("verifucode");
        //而程序生成的验证码是存在放在session中，所以要用session去获取
        String checkcode = (String)request.getSession().getAttribute("checkcode");
        //获取到session之后要将其丢弃
        //判断验证码是否正确
        if(!verifucode.equalsIgnoreCase(checkcode)){
            //错误发送错误信息
            request.setAttribute("err_log","验证码输入错误！！");
            //跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else{
            //获取所有的request对象中的元素(包括username、password、验证码)，并封装在map集合中
            Map<String, String[]> parameterMap = request.getParameterMap();
            //封装table_user对象
            Table_user table_user = new Table_user();
            //在使用BeanUtils中的populate方法去匹配
            try {
                BeanUtils.populate(table_user,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用service对象获取数据库中的username和password
            UserdaoImple UserService = new UserdaoImple();
            UserService.getuserpass()

        }
        //获取数据
            //这个是获取的验证码
        String verifycode = request.getParameter("verifycode");
            //这个使获取的所有数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装对象
        Table_user table_user = new Table_user();
        try {
            BeanUtils.populate(table_user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //验证码校验
        //调用Service服务
        //判断是否登陆成功
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
