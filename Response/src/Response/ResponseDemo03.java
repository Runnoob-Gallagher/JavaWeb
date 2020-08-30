package Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo03")
public class ResponseDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0.获取字符输出流之前，设置默认的流的编码
        //response.setCharacterEncoding("utf-8");  //浣犲ソ锛學orld  但是你只是设置了流的编码，客户端浏览器并不知道。看下一步
        //response.setHeader("content-type","text/html;charset=utf-8");//设置的同时，告诉浏览器也使用这个/看下一步，简化
            response.setContentType("text/html;charset=utf-8");

        //1.设置字符输出流
        PrintWriter pw = response.getWriter();

        //2.输出数据
        pw.write("<h1>你好，World</h1>");  // ???,World
        //pw.write("你好，World!");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
