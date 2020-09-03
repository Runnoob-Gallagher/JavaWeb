package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取Map集合
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check_code = request.getParameter("checkCode");
        System.out.println(check_code);
        //3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCodevalue =(String)session.getAttribute("checkcode_value");
        session.removeAttribute(checkCodevalue);
        System.out.println(checkCodevalue);
        //3.判断验证码对不对
        if(checkCodevalue != null && checkCodevalue.equalsIgnoreCase(check_code)){
            //如果验证码正确，但是用户名密码不一致的话
            if("gallagher".equals(username) && "123".equals(password)){ //全部正确则提示登录等成
            //都验证成功的话，重定向到新页面,但是这是一个重定向，所以有两次请求，需要重新添加信息
                session.setAttribute("user",username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("login_err_msg","用户名或密码输入错误");
                request.getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        }else{
            //验证码不一致，存储提示信息到request
            request.setAttribute("check_err_msg","验证码输入错误");
            //发现错误就转发
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
