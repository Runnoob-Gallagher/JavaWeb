package Servlet;
/*
Servlet生命周期：
    被创建：执行init方法，只执行一次
        Servlet什么时候被创建：默认情况下，第一次访问时，Servlet被创建
            在web.xml中<Servlet>标签下配置Servlet的创建时机
                1.第一次访问时，创建
                    <load-on-startup>的值为负数
                2.服务器启动时，创建
                    <load-on-startup>的值为0或者正整数
        注意：
            Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
                *多个用户在访问时，可能存在线程安全问题
                *解决：尽量不在Servlet中定义成员变量。即使定义了也不要做出修改

    提供服务：执行service方法，执行多次
        每次访问Servlet时，Service方法都会被调用一次。

    被销毁：执行distroy方法，只执行一次
        Servlet被销毁时执行。服务器被关闭时，Servlet被销毁
        只有服务器正常关闭时，才会执行distrtoy方法
 */
import javax.servlet.*;
import java.io.IOException;

public class Servlet02 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet在创建时，会执行这个方法，只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我是init方法");
    }

    /**
     * 获取SerletConfig对象
     * ServletConfig：Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问都会被执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletGo");
    }

    /**
     * 获取Servlet的一些信息：版本、作者等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("我是destroy方法");
    }
}
