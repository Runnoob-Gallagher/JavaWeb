package Demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC对象介绍：
    1.DriverManager:驱动管理对象
        作用一：注册驱动，告诉程序应该使用哪一个数据库驱动jar
        输入的是：Class.forName("com.mysql.jdbc.Driver");  实则为：
        static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
        }     利用其中的静态代码块注册驱动，mysql5之后的jar包可以不用写这部分
        作用二：获取数据库连接
            方法：static Connection getConnection(String url,String user,String password)
    2.Connection:数据库连接对象
        功能一：
            获取执行sql的对象
                * Statement createStatement()
                * PreparedStatement prepareStatement(String sql)
        功能二：
            管理事务
                *开启事务：setAutoCommit(boolean autoCommint):调用该方法设置参数为false，即开启事务
                *提交事务：commit()
                *回滚事务：rollback()
    3.Statement:执行sql的对象
        方法一：boolean execute(String sql):可以执行任意的sql
        方法二：int executeUpdate(String sql):执行DML语句和DDL语句
                返回值为修改的行数
        方法三：ResultSet executeQuery(String sql):执行DQL语句
    4.ResultSet:结果集对象
        方法一：next()游标向下移动一行，你的一个sql查询语句的第一行是行名，所以你要向下移动的；
        方法二：getXxx(参数)
            Xxx:这个Xxx代表数据类型;
            参数：①int类型：代表列的编号，从1开始
                 ②String类型：代表列的名称
    5.PreparedStatement：执行sql的对象（方法更多）
 */
public class IntroduceObject {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        //注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接的对象
            conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla?useUnicode=true&characterEncoding=utf-8", "root", "Gallagher1.");
            //定义执行的sql
            String sql = "INSERT INTO department VALUES (NULL,\"运维事业部\",'北京');";
            //获取执行sql的对象
            stat = conn.createStatement();
            //执行sql
            int i =  stat.executeUpdate(sql);
            System.out.println(i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stat != null){
                    stat.close();
                }
               // stat.close();     //这里和之前一样，因为stat在try代码块中，作用域仅在try中。所以要定义为全部变量
                //stat,close();还有 如果连接地址写错了，那么就执行不到stat = conn.createStatement();那么stat.close()会爆空指针异常
             /*   Exception in thread "main" java.lang.NullPointerException
                at Demo01.IntroduceObject.main(IntroduceObject.java:60)  所以这里做下判断*/
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
