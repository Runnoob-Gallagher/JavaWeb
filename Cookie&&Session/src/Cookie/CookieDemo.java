package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //8.设置响应的消息体的数据格式及编码
        response.setContentType("test/html;charset=utf-8");

        //1.获取所有的cookie
        Cookie[] CKA = request.getCookies();//想想为什么是request来获取cookie，因为你服务器response发出cookie，可看f12
        //9.这里还有一种情况，有cookie但是不是为lasttime的cookie
        boolean flag = false;//没有cookie为lasttime的cookie
        //2.遍历cookie数组
        if(CKA != null && CKA.length > 0){
            for (Cookie cookie : CKA) { //这就是你获取的cookie，这里有可能是没有值的
                //2.1 获取cookie的名称
                String name = cookie.getName();
                //3.判断这个名称是不是等于lastTime，因为要用来判断是不是使用过
                if("lastTome".equals(name)){
                    //3.1如果相等，就说明来过
                    flag=true;
                    //3.1.1获取上次来的时间
                    Date date = new Date();
                    //修改时间格式：
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String value_day = sdf.format(date);
                    String encode = URLEncoder.encode(value_day);
                    //4.设置cookie的value
                    cookie.setValue(encode);
                    //7.设置cookie的存活时间
                    cookie.setMaxAge(60*60*24);
                    //5.设置值之后就要发送回去，你发回去之后。新的cookie就算是(lastTime,"yyyy-mm-dd HH:mm:ss")
                    response.addCookie(cookie);
                    //6.重新获取cookie的值作为value
                    String value = cookie.getValue();
                    //最后将值输出到页面上,这里因为是服务器发出的，所以要用respong
                    response.getWriter().write("<h1>" + "欢迎老顾客，你上次造访的时间是"+ value +" </h1>");
                    break; //找到了就break
                }
            }
        }
        if(CKA == null || CKA.length == 0 || flag == false ){//说明就没来过
            //没来过，也要打印时间
            Date date = new Date();
            //修改时间格式：
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value_day = sdf.format(date);
            String encode = URLEncoder.encode(value_day);
            Cookie cookie = new Cookie("lastTime",encode);
            //4.设置cookie的value
            cookie.setValue(encode);
            //7.设置cookie的存活时间
            cookie.setMaxAge(60*60*24);
            //5.设置值之后就要发送回去，你发回去之后。新的cookie就算是(lastTime,"yyyy-mm-dd HH:mm:ss")
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
