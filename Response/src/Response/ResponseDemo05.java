package Response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo05")
public class ResponseDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //仍然需要设置编码格式
        response.setContentType("text/html;charset=utf-8");
        //1.输出字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2.输出数据，因为是字节输出流你就要进行转化
        sos.write("想输出什么就输出什么AAAA1111".getBytes());  //java.io.CharConversionException: Not an ISO 8859-1 character: [随]
        ServletContext context = this.getServletContext();
        Object name = context.getAttribute("name");
        System.out.println(name); //这段代码是在另外一个包下的，这里我都能访问，说明ServletContext的作用范围是在整个应用中
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
