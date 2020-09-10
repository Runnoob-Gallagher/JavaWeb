package web;

import domain.Table_user;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为是post请求，需设置编码
        request.setCharacterEncoding("utf-8");

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
