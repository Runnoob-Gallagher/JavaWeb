package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
JDBC 工具类  使用Durid连接池
 */
public class JdbcUtils {

    //定义一个DataSource成员变量
    private static DataSource ds;
    static{
        try {

            // 1.加载配置文件
            Properties pro = new Properties();
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            // 2.初始化连接池对象
             ds = DruidDataSourceFactory.createDataSource(pro);
            System.out.println(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取连接池对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
