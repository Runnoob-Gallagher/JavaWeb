package Test;

import Utils.JdbcUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class dbUtilTest {
    private static DataSource ds;
    @Test
    public void getdata(){
        Properties pro = new Properties();
        InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            pro.load(resourceAsStream);
            // 2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
            System.out.println(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(ds);
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
