package Demo01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo08SqlInjection {
    public static void main(String[] args) {
        //接收键盘输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");   //a' or 'a' = 'a
        //就相当于   select * from login where username = 'dasdasa' and password = 'a' or 'a' = 'a' ;
        String password = sc.nextLine();
        boolean flag = login(username,password);
        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("登录失败");
        }
    }
    public static boolean login (String username,String password){
        if( username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
             conn = Demo07Utils.getconnection();
             stat = conn.createStatement();
             String sql = "select * from login where username = '"+username+"' and password = '"+password+"' ";
            result = stat.executeQuery(sql);
           /*  if(result.next()){
                 return true;
             }
             return false;*/
            return result.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Demo07Utils.close(result,stat,conn);
        }
        return false;
    }
}
