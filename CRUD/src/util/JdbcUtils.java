package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

        static DataSource dataSource;
        static {
        try {
        Properties pro = new Properties();
        //使用类加载器获取配置文件路径
        InputStream rs = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //加载该配置文件
        pro.load(rs);
        dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }


        //创建获取数据库连接对象的方法
        public static DataSource getDataSource() {
            return dataSource;
        }
        //创建获取数据库连接对象的方法
        public static Connection getConnection() throws SQLException {
            return dataSource.getConnection();
        }
}
