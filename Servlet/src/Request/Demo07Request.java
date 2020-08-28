package Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*2. 请求转发：一种在服务器内部的资源跳转的方式
        步骤：
        1.通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
        2.使用RequestDispatcher对象来进行转发：forward(ServletRequest request,ServletResponse response)*/
        /*执行结果：
                现在执行的是Demo07Request
                现在执行的是Demo08Request*/

@WebServlet("/demo07Request")
public class Demo07Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("现在执行的是Demo07Request");
        request.setAttribute("how","why not me");   //注意这个要写在请求转发之前，不然你都请求转发了，我赋值了也没用了
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/demo08Request");
        requestDispatcher.forward(request,response);
       /* request.getRequestDispatcher("/demo08Request").forward(request,response);*/
        //现在这个就是一次请求，会转发到demo08Request

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
