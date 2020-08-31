package ServletContext;

import Utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/servletContextDown")
public class ServletContextDown extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = request.getParameter("filename");
        System.out.println(filename);
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + filename);
        //2.2用字节流关联
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //3.设置response的响应头
            //3.1 设置响应头类型：content-type
        String type = servletContext.getMimeType("filename");
        response.setHeader("content-type",type);
            //3.2 设置响应头打开方式：content-disposition
        response.setHeader("content-disposition","attachment;filename="+filename);

        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.将输入流的数据写到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        //定义缓冲区
        byte[] bt = new byte[1024*8];
        int len=0;
        while((len = fileInputStream.read(bt)) != -1){
            outputStream.write(bt,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
