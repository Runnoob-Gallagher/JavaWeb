package Cookie;
/*
Cookie快速入门
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo01CookieSend")
public class Demo01CookieSend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie对象
        Cookie ckA = new Cookie("name","Gallagher");
        Cookie ckB = new Cookie("Gallagher", "hard");
        //使用response相应发送Cookie信息到客户端，所以要使用response
        response.addCookie(ckA);
        response.addCookie(ckB);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
