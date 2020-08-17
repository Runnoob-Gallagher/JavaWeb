package Demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo07Jdbc {
    public static void main(String[] args) {
        List<Demo07Employee> list = new ArrayList();
        Demo07Employee d7e = new Demo07Employee();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接对象
            //conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            conn = Demo07Utils.getconnection();
            //获取执行sql的对象
            stat = conn.createStatement();
            //执行的DMLsql
            String sql = "select * from department";
            //执行sql,并获得结果集
            result = stat.executeQuery(sql);
            //遍历结果集，并将其存在在集合中
            while (result.next()){
                int id = result.getInt("id");
                String dep_name = result.getString("dep_name");
                String dep_location = result.getString("dep_location");
                //d7e = new Demo07Employee();
                d7e.setDep_location(dep_location);
                d7e.setDep_name(dep_name);
                d7e.setId(id);
                list.add(d7e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           /* if(result != null){
                try {
                    result.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
            }*/
            Demo07Utils.close(result,stat,conn);
        }
        System.out.println(list);
    }
}
