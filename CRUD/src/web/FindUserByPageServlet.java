package web;




import domain.PageBean;
import domain.Table_user;
import service.Imple.UserServiceImple;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //首先currentPage和rows是客户端发送到服务器上的，这样我们来获取参数
         String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage)){
            currentPage="1";
        }
        if(rows == null || "".equals(rows)){
            rows="6";
        }
        //获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();
        System.out.println(condition + " ");

//        System.out.println(currentPage+"  " + rows);
        //调用Service查询PageBean
        UserService userService = new UserServiceImple();
        //现在因为多了一个条件查询要加condition,方法需重构
        PageBean<Table_user> pb = userService.getPageBean(currentPage,rows,condition);//因为你根据这个查询能获得一个页面，页面内容展示为Table_user的内容
        //将PageBean存入到request中
        System.out.println(pb);
        request.setAttribute("pageBean_list",pb);
        //转发到list.jsp中
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
