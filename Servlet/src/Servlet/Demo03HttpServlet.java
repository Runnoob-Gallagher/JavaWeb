package Servlet;
/*HttpServlet:因为需要对数据请求作出判断，POST或者GET，那么就要进行判断。HttpServlet就是对这一操作进行了封装*/
/*定义内继承HttpServlet
复写doGet/doPost方法*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Do")
public class Demo03HttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet....");
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost....");
        System.out.println(req);
    }
}
