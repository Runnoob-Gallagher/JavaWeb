package Runnoob;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie cookie = new Cookie("lastTime", System.currentTimeMillis()+"");
        resp.addCookie(cookie);
        if(cookies != null){
            for (int i = 0; i <cookies.length ; i++) {
                if("lastTime".equals(cookie.getName())){
                    pw.write("你上一次访问时间是：" + cookie.getValue());
                }
            }
        }else {
            pw.write("这是你第一次访问");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
