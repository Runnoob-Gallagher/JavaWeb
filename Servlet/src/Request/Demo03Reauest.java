package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo03Reauest")
public class Demo03Reauest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String header = request.getHeader("User-Agent");
        if(header.contains("Chrome")){
            System.out.println("你使用的是谷歌浏览器");
        }else if(header.contains("Edg")){
            System.out.println("你使用的是微软浏览器");
        }
    }
}
