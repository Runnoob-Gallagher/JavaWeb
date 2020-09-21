package Runnoob;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


public class CharactorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //加上字符编码设置，就可以解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("杨洁好好学习");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/db.properties");
        System.out.println(realPath + "realPath");
        InputStream resource = context.getResourceAsStream("/WEB-INF/classes/db.properties");
        System.out.println(resource + "resource");
        byte[] bytes = context.getContextPath().getBytes();
        response.getOutputStream().write(bytes);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
