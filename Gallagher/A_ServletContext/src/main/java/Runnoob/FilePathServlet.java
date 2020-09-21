package Runnoob;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FilePathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取资源的绝对路径
        String realPath1 = this.getServletContext().getRealPath("/");
        System.out.println(realPath1);
        String realPath2 = this.getServletContext().getRealPath("/") + "WEB-INF\\c9d44bca441e98bb13136d8cbe73256.jpg";
        System.out.println(realPath2 + "    repath2");
        String realPath = "E:\\JavaWeb\\Gallagher\\A_ServletContext\\target\\A_ServletContext\\WEB-INF\\classes\\c9d44bca441e98bb13136d8cbe73256.jpg";/*this.getServletContext().getRealPath("/c9d44bca441e98bb13136d8cbe73256.jpg");*/
        System.out.println(realPath + "   " + " path");


        //获取文件名，截取路径 subString 和 lastIndexof(); 就是找到这个/，然后后面就是文件名，截取出来
        String filename = realPath.substring(realPath.lastIndexOf("\\" ) + 1 );
        //设置让浏览器支持下载，即设置响应头  当文件名是中文时会乱码，直接转码
        resp.setHeader("Content-Disposition","attachment:filename="+ URLEncoder.encode(filename));
        //创建下载文件的流
        FileInputStream fileInputStream = new FileInputStream(realPath2);
        //创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //获取OutputStream对象,用response对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //将FileInputStream流写入到buffer缓冲区
        while((len = fileInputStream.read(buffer))!= 0){
            outputStream.write(buffer,0, len);
        }
        //关闭流
        fileInputStream.close();
        outputStream.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
