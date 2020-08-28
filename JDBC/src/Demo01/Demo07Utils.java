package Demo01;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class Demo07Utils {
        private static String driver;
        private static String url;
        private static String user;
        private static String password;
        static {
            //直接去读properties参数配置文件
            //你用类加载器去调用文件位置
            ClassLoader classLoader = Demo07Utils.class.getClassLoader();
            URL resource = classLoader.getResource("Jdbc.properties");
            String path = resource.getPath();
            //根据路径去找到配置文件
            Properties pro = new Properties();
            try {
                pro.load(new FileReader(path));//这里面传递路径
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    public static Connection getconnection() throws SQLException {
            /*
            public static Connection getConnection(String url)
                                throws SQLException   数据库连接的超级接口：Connection
            看之前写的：Connection conn = null;
                      conn = DriverManager.getConnection("jdbc:mysql://39.98.137.124:3306/Tesla", "root", "Gallagher1.");
             */
        return DriverManager.getConnection(url,user,password);
    }
    public static void close(ResultSet result, Statement stat, Connection conn){
        if(result != null){
            try {
                result.close();
                result=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
                stat = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Statement stat, Connection conn){
        if(stat != null){
            try {
                stat.close();
                stat=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
