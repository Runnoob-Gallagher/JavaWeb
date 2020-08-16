package Demo01;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo05ObjcetAccquire {
    public static void main(String[] args) {
        Demo05ObjcetAccquire doa = new Demo05ObjcetAccquire();
        List<Demo05Emp> list = doa.getAll();
        System.out.println(list);
    }

    public List<Demo05Emp> getAll(){
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        Demo05Emp de = null;
        List<Demo05Emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
            String sql = "select * from emp";
            stat = conn.createStatement();
            result= stat.executeQuery(sql);
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString("name");
                int age = result.getInt("age");
                String dep_name =  result.getString("dep_name");
                String dep_location = result.getString("dep_location");
                de = new Demo05Emp();
                de.setAge(age);
                de.setDep_name(dep_name);
                de.setDep_location(dep_location);
                de.setId(id);
                de.setName(name);
                list.add(de);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
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
            }
        }
        return list;
    }
}
