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
import java.util.Map;


@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findUserid = request.getParameter("id");
        UserService findUserService = new UserServiceImple();
        Table_user table_user = findUserService.findUser(findUserid);
        //将Table_user对象保存在request中
        request.setAttribute("find_table_user",table_user); //后面要用EL表达式取值
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
