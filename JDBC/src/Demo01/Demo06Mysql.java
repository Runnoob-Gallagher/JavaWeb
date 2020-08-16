package Demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo06Mysql {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet resultSet = null;
        List<Demo06Emp> list = new ArrayList<>();
        Demo06Emp de = null;
        try {
            //注册驱动
           // Class.forName("com.mysql.jdbc.Driver");
            //Class.forName()
            //获取连接对象
            //conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            conn = Utils.getConnection();
            //获取执行sql的对象
            stat = conn.createStatement();
            //执行的sql
            String sql = "select * from emp";
            //执行sql的语句,获得结果集
            resultSet = stat.executeQuery(sql);
            //遍历结果集获取结果
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String dep_name = resultSet.getString("dep_name");
                String dep_location = resultSet.getString("dep_location");
                de = new Demo06Emp();
                de.setAge(age);
                de.setDep_location(dep_location);
                de.setDep_name(dep_name);
                de.setId(id);
                de.setName(name);
                list.add(de);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           /* if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
           Utils.close(resultSet,stat,conn);
        }
        System.out.println(list);
    }
}
