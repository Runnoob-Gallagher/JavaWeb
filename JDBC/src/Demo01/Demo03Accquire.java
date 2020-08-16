package Demo01;

import java.sql.*;

public class Demo03Accquire {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet result = null;
        Statement stat = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取Mysql连接对象
            conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            //定义SQL
            String sql = "select * from department";
            //获取执行sql对象
            stat = conn.createStatement();
            //执行sql,获取结果集
            result = stat.executeQuery(sql);  //结果集也是一个资源，需要关闭的
            //处理结果1.让游标下移  2.获取改行的数据
            result.next();
            String id = result.getString(1);
            String dep_location = result.getString("dep_location");
            String dep_name = result.getString("dep_name");
            String answer = id + " " +dep_location+" "+dep_name;
            System.out.println(answer);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(result == null){
                    result.close();
                }
                if(stat == null){
                    stat.close();
                }
               if(conn == null){
                   conn.close();
               }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
