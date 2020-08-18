package Demo01;

import java.sql.*;
import java.util.Scanner;

/*
步骤： //解决sql注入问题：select * from login where username = 'dasdasa' and password = 'a' or 'a' = 'a' ;   a' or 'a' = 'a
    1.sql注入问题：拼接sql造成 利用恒等式
    2.解决sql注入问题：使用PreparedStatement对象来解决
    3.预编译的SQL:使用?作为占位符
    4.1.导入驱动jar包
      2.注册驱动
      3.获取数据库连接对象
      4.定义sql：参数使用?作为占位符 select * from login where username = ? and password = ?;
      5.获取执行sql语句的对象preparedStatement   Connection.prepareStatement(String sql)
      6.给?赋值
        方法：setXxx(参数1，参数2)
            *参数1：?的位置从编号1开始
            *参数2：?的值
      7.执行sql，接收返回结果，不需要传递sql语句。前面已经进行了传递
      8.处理结果
      9.释放资源
 */
public class Demo09Prepara {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入用户名：");
        String username = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        boolean answer = new Demo09Prepara().Login( username, password);
        if(answer){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
    public boolean Login(String username,String password){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = Utils.getConnection();
            String sql = "select * from login where username = ? and password = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);//这里开始写的 “username“ 不能加双引号，本来就是String类型的了
            preparedStatement.setString(2,password);
            result = preparedStatement.executeQuery();//这里就不用传SQL了
           /* if (username == null || password == null){
                return false;
            }*/
            return result.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Utils.close(result,preparedStatement,conn);//相当于父类引用指向子类对象 PrepareStatement extends Statement
        }
        return false;
    }
}
