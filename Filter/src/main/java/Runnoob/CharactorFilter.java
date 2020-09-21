package Runnoob;

import javax.servlet.*;
import java.io.IOException;

public class CharactorFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器还没启用时我就会被执行");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(request,response);
        System.out.println("过滤器已经执行");
    }

    public void destroy() {
        System.out.println("过滤器启动完成后我就会被销毁");
    }
}
