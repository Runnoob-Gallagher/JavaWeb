package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/demo02Request")
public class Demo02Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String getHeader(String name):通过请求头的名称获取请求头的值   类似键值

        //1.Enumeration<String> getHeaderNames():获取所有的请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()){
            String element_name = headerNames.nextElement();
            String header = request.getHeader(element_name);
            System.out.println(header);
        }
    }
}
