package web;

import domain.Table_user;
import service.Imple.UserServiceImple;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //因为这里是web层中的servlet，用于接收service层中得到的综合处理结果，所以转到service层去操作
        //创建service层的逻辑操作获取得到的值，所以要创建该类的对象获取方法的返回值
        UserService service = new UserServiceImple();
        List<Table_user> tableUsers = service.findAll();
        //将查询出来的结果存放在request域中
        request.setAttribute("usermessage",tableUsers);
        //转发到list.jsp页面中区，
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
