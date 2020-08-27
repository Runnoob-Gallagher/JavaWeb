package Servlet;
/*HttpServlet(抽象类)继承GenericServlet(抽象类)，两个均实现Servlet接口
 * 看源码：
 *   public abstract class GenericServlet implements Servlet, ServletConfig, Serializable {
    private static final long serialVersionUID = 1L;
    private transient ServletConfig config;

    public GenericServlet() {
    }

    public void destroy() {
    } {
    GenericServlet将Servlet接口中的其他方法做了默认空实现，只将Service()方法作为抽象
    *       将来定义Servlet类时，可以继承GenericService，实现service()方法即可
    * */
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Gen")
public  class Demo02GeneriServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet");
    }
}
