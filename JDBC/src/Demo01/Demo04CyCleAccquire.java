package Demo01;

import java.sql.*;

public class Demo04CyCleAccquire {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            String sql = "select * from emp";
            stat = conn.createStatement();
            result = stat.executeQuery(sql);
            while(result.next()){
                    String id = result.getString(1);
                    String name = result.getString("name");
                    String age = result.getString("age");
                    String dep_name = result.getString(4);
                    String dep_location = result.getString("dep_location");
                    System.out.println(id + " " + name + " " + age + " " + dep_name + " " + dep_location);
                }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(result != null && stat != null && conn != null )
            try{
                result.close();
                stat.close();
                conn.close();//这样是不规范的，可能上面一个报错，下面一个就不能执行了
            }catch(SQLException e){
                e.printStackTrace();
                 }
            }
        }

    }

