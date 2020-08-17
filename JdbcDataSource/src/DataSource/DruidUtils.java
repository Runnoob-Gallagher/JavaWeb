package DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
该工具类作用：
        1.定义一个类DruidUtils
        2.提供静态代码块加载文件，初始化数据库连接对象
        3.提供方法
            ①获取连接方法：通过数据库连接池获取对象
            ②释放资源
            ③获取连接池的方法
 */
public class DruidUtils {

    //获取datasource成员变量
    private static DataSource datesource;
    static {
        Properties pro = new Properties();
        InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            //加载配置文件
            pro.load(resourceAsStream);
            //获取DataSource
            datesource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //方法一：获取连接
    public static Connection getconnection() throws SQLException {
        return datesource.getConnection();
    }
    //方法二：关闭资源
    public static void close(ResultSet result, Statement stat,Connection conn){
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
    public static void close(Statement stat,Connection conn){
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
    //方法三、获取连接池的方法
    public static DataSource getdatasource(){
        return datesource;
    }
}
