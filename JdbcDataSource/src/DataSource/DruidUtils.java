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
        DataSource的getconnection和Connection的getconnection有什么区别：
        一个是你自己控制了jdbc最底层的初始化并拿到连接（DriverManiger)
        一个是由容器封装成数据源（底层也是第一种方式），然后获取连接。
        使用DataSource的好处是可以在外边配置，不用自己写配置文件了
        区别在于关闭:
            DataSource 默认会重用连接，所以不会真正的close掉物理连接的而 Connection 则会真的关闭
 */

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
        /*
        Connection getConnection() throws SQLException  尝试建立与此 DataSource 对象所表示的数据源的连接。
        他的超级接口是DateSource  不是Connection
        public static Connection getConnection(String url,
                                       Properties info)
                                throws SQLException

         */
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
