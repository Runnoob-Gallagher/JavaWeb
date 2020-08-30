package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
重定向
 */
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我马上要去做重定向了");
            /*//1.设置状态码为302
            response.setStatus(302);
            //设置响应头location
            response.setHeader("location","/Response/responseDemo02");*/

            //简单重定向方法：sendRedirect  等价于上面两句
            response.sendRedirect("/Response/responseDemo02");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
