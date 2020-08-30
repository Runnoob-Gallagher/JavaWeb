package Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo04")
public class ResponseDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //仍然需要设置编码格式
        response.setContentType("text/html;charset=utf-8");
        //1.输出字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //2.输出数据，因为是字节输出流你就要进行转化
        sos.write("想输出什么就输出什么".getBytes());  //java.io.CharConversionException: Not an ISO 8859-1 character: [随]

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
