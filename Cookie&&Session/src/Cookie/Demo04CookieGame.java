package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/demo04CookieGame")
public class Demo04CookieGame extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");
        //获取从服务器端发送的cookie信息
        Cookie[] reqcks = request.getCookies();
        //如果获取的cookies数组存在就遍历这个reqcks数组
        if(reqcks != null && reqcks.length >0){
            for (Cookie reqck : reqcks) {
                //获取该reqck的键值
                String reqckName = reqck.getName();
                //判断该name是不是等于lastTime
                if("lastTime".equals(reqckName)){ //如果相等，就说嘛来过。那么后续进行时间确定
                    Date req_date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//因为这里有中文有空格，需要设置字符集编码解码
                    String format_date = sdf.format(req_date);
                    String encode_date = URLEncoder.encode(format_date);
                    //将这个时间给到cookie的值,然后就是服务器将时间重新响应到cookie
                    String decode_time = URLDecoder.decode(encode_date);
                    reqck.setValue(encode_date);
                    response.addCookie(reqck);
                    response.getWriter().write("欢迎老顾客再次光临，你上次访问的时间是：" + decode_time);
                }
            }
        }
        if(reqcks == null || reqcks.length == 0 ){//如果没有产生cookie，就说嘛是第一次访问，将这个时间复制
            Date req_date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//因为这里有中文有空格，需要设置字符集编码解码
            String format_date = sdf.format(req_date);
            String encode_date = URLEncoder.encode(format_date);
            //将这个时间给到cookie的值,然后就是服务器将时间重新响应到cookie
            Cookie cookie = new Cookie("lastTime",encode_date);
            cookie.setValue(encode_date);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次访问</h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
