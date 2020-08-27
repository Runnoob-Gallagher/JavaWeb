package Servlet;
/*HttpServlet(抽象类)继承GenericServlet(抽象类)，两个均实现Servlet接口
* 看源码：
*   public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {*/
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Demo01")
public class Demo01Servlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Good Good study,Day Day up!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
