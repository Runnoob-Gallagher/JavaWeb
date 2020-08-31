package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo05")
public class ServletContextDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = this.getServletContext();
        //获取服务器真实路径
        String realPathA = context.getRealPath("/Middle.txt");  //所以这个“/”就代表E:\JavaWeb\Response\out\artifacts\Response_war_exploded
        System.out.println(realPathA);////E:\JavaWeb\Response\out\artifacts\Response_war_exploded\Middle.txt,表示web目录下的路径
        //以此作为根路径，访问其他两个文件Outer.txt和Inner.txt
        String realPathB = context.getRealPath("/WEB-INF/Inner.txt");
        System.out.println(realPathB); //E:\JavaWeb\Response\out\artifacts\Response_war_exploded\WEB-INF\Inner.txt
        //访问src路径下的Outer文件，因为他会在web-inf下复制一份，我们就去访问他的
        String realPathC = context.getRealPath("/WEB-INF/classes/Outer.txt");
        System.out.println(realPathC);//E:\JavaWeb\Response\out\artifacts\Response_war_exploded\WEB-INF\classes\Outer.txt
        File file = new File(realPathA);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
