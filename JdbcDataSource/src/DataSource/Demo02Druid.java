package DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/*
1. 导入jar包： druid-1.0.9.jar
2. 定义配置文件：
        格式：properties
        可以执行任意名称，放在任意路径下
3.获取数据库连接池对象：通过工厂获取   DruidDataSourceFactory
4.获取连接：getConnection

 */
public class Demo02Druid {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件,查找配置文件
        Properties pro = new Properties();
        ClassLoader classLoader = Demo02Druid.class.getClassLoader();
        URL resource = classLoader.getResource("druid.properties");
        String path = resource.getPath();
        pro.load(new FileReader(path));
        //获取数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        System.out.println(dataSource);
        for (int i = 1; i <13 ; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + " " + connection);
        }
    }


}
