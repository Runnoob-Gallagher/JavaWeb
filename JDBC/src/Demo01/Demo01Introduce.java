package Demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC:是一套官方定义的操作所有关系型数据库的规则，即接口；各个数据库厂商去实现这个接口，提供数据库驱动jar包。
真正利用的是驱动jar包中的实现类
实现步骤：
    1.导入驱动jar包
        ①复制驱动文件到libs下面
        ②Add as Library
    2.注册驱动
    3.获取数据库连接对象Connection
    4.定义sql
    5.获取执行sql语句的对象 Statement
    6.执行sql，接收返回结果
    7.处理结果
    8.释放资源
 */
public class Demo01Introduce {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla?useUnicode=true&characterEncoding=utf-8", "root", "Gallagher1.");
        //定义SQL语句
        String sql = "UPDATE department SET dep_location = \"重庆\" WHERE id = 2;";
        //获取执行SQL的对象，Statement
        Statement stmt = conn.createStatement();
        //执行sql
        int i = stmt.executeUpdate(sql);
        //查看执行结果
        System.out.println(i);
        //释放资源
        stmt.close();
        conn.close();
    }
}
