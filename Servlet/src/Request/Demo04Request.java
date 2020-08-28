package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo04Request")
public class Demo04Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        System.out.println(referer);//直接通过浏览器访问，输出null。根据路径或者超链接访问页面就有了
        //http://localhost:8080/Request/Movie.html

        //防盗链
        if (referer != null) {
            if (referer.contains("/Request")) {
                System.out.println("你能正常观看小黄片");
            } else {
                System.out.println("看个锤子，好好学习");
            }
        }
    }
}
