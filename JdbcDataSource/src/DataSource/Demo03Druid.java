package DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
利用工具类来操作Druid
 */
public class Demo03Druid {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            conn = DruidUtils.getconnection();
            //定义sql
            String sql = "insert into login values (null,?,?)";
            //获取执行sql的对象
            preparedStatement = conn.prepareStatement(sql);
            //执行sql前对？赋值
            preparedStatement.setString(1,"YangJie");
            preparedStatement.setString(2,"Yanghao");
            //执行sql
            int count = preparedStatement.executeUpdate();
            //判断执行结果
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(preparedStatement,conn);//因为PrepareStatement extends Statement;
        }
    }


}
