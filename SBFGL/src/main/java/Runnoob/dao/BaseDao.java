package Runnoob.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        InputStream properties_path = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        try {
            pro.load(properties_path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件
        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
    }
        //获取数据库连接对象
        public static Connection getConnection(){
        Connection connection = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
        //编写查询公共类
        public static ResultSet excute(Connection conn,String sql,Object[] objects,ResultSet resultSet,PreparedStatement preparedStatement) throws SQLException {
            //传入预编译sql,也提出来？？
            preparedStatement = conn.prepareStatement(sql);
            //传入sql中的值
            for (int i = 0; i <objects.length ; i++) {
                //这个根据参数的位置，传递参数
                preparedStatement.setObject(i+1,objects[i]);
            }
            //执行sql,将ResultSet resultSet提到参数中去？？？
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        }
            //编写增删公共类
            public static int excute(Connection conn,String sql,Object[] objects,PreparedStatement preparedStatement) throws SQLException {
                //传入预编译sql,也提出来？？
                preparedStatement = conn.prepareStatement(sql);
                //传入sql中的值
                for (int i = 0; i <objects.length ; i++) {
                    //这个根据参数的位置，传递参数
                    preparedStatement.setObject(i+1,objects[i]);
                }
                //执行sql,将ResultSet resultSet提到参数中去？？？
                int updaterows = preparedStatement.executeUpdate();
                return updaterows;
            }
            //关闭资源
                public static boolean closeResouce(Connection conn,PreparedStatement state,ResultSet result){
                    boolean flag = true;
                    if(result != null){
                        try {
                            result.close();
                            //促进让GC回收
                            result = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }
                    if(state != null){
                        try {
                            state.close();
                            //促进让GC回收
                            state = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }
                    if(conn != null){
                        try {
                            conn.close();
                            //促进让GC回收
                            conn = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                            flag = false;
                        }
                    }
                    return flag;
                }
}
