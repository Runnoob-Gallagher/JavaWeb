package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/demo02Session")
public class Demo02Session extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session，因为session是服务器端发出的，所有用reques获取
        HttpSession session = request.getSession();
        //获取session的值
        Object name = session.getAttribute("name");
        Cookie cookie = new Cookie("JSESSION",session.getId());//这个session.getId()就是获取JSESSION的方法
        cookie.setMaxAge(60);
        System.out.println(session.getId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
