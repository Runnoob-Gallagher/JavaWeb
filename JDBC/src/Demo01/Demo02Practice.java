package Demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02Practice {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象,肯定要用驱动去获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            //获取执行sql的对象
            stat = conn.createStatement();
            //需要执行的sql
            String sql = "UPDATE department SET dep_name = \"发展部\" WHERE dep_location = '重庆';";
            //执行sql
            int count = stat.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

}
