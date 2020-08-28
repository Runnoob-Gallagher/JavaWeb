package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


//设置流的编码：request.setCharacterEncoding("utf-8");

@WebServlet("/demo06Request")
public class Demo06Request extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取请求参数 POST
        //* String getParameter(String name):根据参数名称  username=ls&password=123
        /*String name = request.getParameter("username");
        System.out.println("post");
        System.out.println(name);*/
        ////* String[] getParameterValue(String name):根据参数名称获取参数值得数组  hobby=xx&hobby=xxx
       /* String[] parameterValues = request.getParameterValues("hobby");
        for (String para:parameterValues
             ) {
            System.out.println(para);
        }*/
        //* Map<String,String[]> getParameterMap():获取所有参数的map集合
      /*  Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> stry_key = parameterMap.keySet();
        for (String key: stry_key
             ) {
            String[] strings = parameterMap.get(key);
            System.out.println(key);
            for (String value : strings) {
                System.out.println(value);
                System.out.println("---------");
            }
        }*/

        Enumeration<String> headerNames = request.getParameterNames();
        while (headerNames.hasMoreElements()){
            String element = headerNames.nextElement();
            System.out.println(element);
            String element1 = request.getParameter("element");
            System.out.println(element1);
            System.out.println("__________");
        }
    }

    protected void
    doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  //获取请求参数 POST
        String name = request.getParameter("username");
        System.out.println("get");
        System.out.println(name);*/
        this.doPost( request,  response);
    }
}
