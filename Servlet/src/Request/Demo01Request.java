package Request;
/*
request对象继承体系结构：
        ServletRequest    ---接口
        |继承
        HttpServletRequest   ---接口
        |实现
        org.apache.catalina.connector.RequestFacade   ----tomcat类实现

        request功能：
        1.获取请求消息数据
        *请求行：
        GET /Servlet/req HTTP/1.1
        方法：获取请求方式 ：GET
        * String getMethod();
        获取虚拟目录： /Servlet
        * String getContextPath()
        获取Servlet路径： /req
        * String getServletPath()
        获取get方式请求参数：name=Gallagher
        * String getQueryString()
        获取请求URI：/Servlet/req
        * String getRequestURI() /Servlet/req
        * StringBuffer getRequestURL() http://localhost/Servlet/req
        获取协议及版本：HTTP/1.1
        * String getProtocol()
        获取客户机的IP地址
        * String getRemoteAddr()*/

//import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo01Request")  //http://localhost:8080/Request/demo01Request?name=Gallagher
public class Demo01Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.方法：获取请求方式 ：GET    --->String getMethod();
        String method = request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录： /Servlet  --->String getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet路径： /req   --->String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4.获取get方式请求参数：name=Gallagher  --->String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI：/Servlet/req    --->String getRequestURI()  StringBuffer getRequestURL()
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本：HTTP/1.1    --->String getProtocol()
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的IP地址  --->String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
