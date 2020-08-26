package Servlet;
/*
IDEA与TOMCAT的相关配置
    1.IDEA会为每一个tomcat部署的项目单独建立一份配置文件
        *Using CATALINA_BASE:   "C:\Users\ASUS\.IntelliJIdea2019.1\system\tomcat\_HTML标签
        C:\Users\ASUS\.IntelliJIdea2019.1\system\tomcat\_HTML标签\conf\Catalina\localhost
        这个目录下是ServletA.xml。回忆tomcat部署的第三种方式
 */
import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*http://localhost:8080/ServletA/ServletA
    第一个ServletA是虚拟路径  第二个ServletA是Servlet资源路径*/

@WebServlet(urlPatterns = "/ServletA")  /*也可以(value="/ServletA")或者("/Servlet") 就是("Servlet资源路径")*/
public class Servlet01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet3.0");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
