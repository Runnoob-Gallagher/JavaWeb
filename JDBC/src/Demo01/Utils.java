package Demo01;
//想好怎么写：  如何保证只加载一次，如何保证抛出异常又能执行代码，确定返回值类型是什么，properties文件该放哪？？？
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class Utils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        ClassLoader classLoader = Utils.class.getClassLoader();
       /* URL resource = classLoader.getResource("Jdbc.properties");
        String path = resource.getPath();*/ //这里用两种不同的读取方法最终都是要用properties去加载
        InputStream resourceAsStream = classLoader.getResourceAsStream("Jdbc.properties");
        Properties pro  = new Properties();
        try {
           /* pro.load(new FileReader(path));*/
            pro.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = pro.getProperty("url");
        user = pro.getProperty("user");
        password = pro.getProperty("password");
        driver = pro.getProperty("driver");
        try {
            Class.forName(driver);//mysql的驱动也是只加载一次。就直接写在静态代码块里了
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {

            return DriverManager.getConnection( url, user, password);

    }
    public static void close(ResultSet resultSet, Statement stat, Connection conn){
        if(resultSet != null){
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
        }
    }
    public static void close( Statement stat, Connection conn){
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
}
