package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有cookies
        Cookie[] respcookies = request.getCookies();
        //判断cookies是否存在，然后获取cookies
        if(respcookies != null && respcookies.length != 0){
            Cookie[] resqcookies = request.getCookies();
            for (Cookie resqcookie : resqcookies) {
                //获取cookie的名称
                String name = resqcookie.getName();
                if(resqcookie.equals(name)){
                //如果存在name，说明之前访问过
                    System.out.println();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
