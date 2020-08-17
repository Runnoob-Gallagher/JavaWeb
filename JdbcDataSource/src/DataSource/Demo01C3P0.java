package DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01C3P0 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象    这个里面可以指定参数配置 ComboPooledDataSource("otherc3p0");
        DataSource ds = new ComboPooledDataSource();
        //获取连接对象
        Connection connection = ds.getConnection();
        System.out.println(connection);  //这里我没有导入mysql相关的jar包：警告: Could not load driverClass com.mysql.jdbc.Driver
    }

}
