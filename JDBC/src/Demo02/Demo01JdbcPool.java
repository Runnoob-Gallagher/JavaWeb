package Demo02;
/*
数据库连接池：就相当于一个容器（集合），用以存放数据库连接的容器
           当系统初始化之后，容器被创建，容器中会申请一些连接对象，当用户访问数据库时，从容器中获取连接对象，用户访问完之后，将连接对象归还。
实现：
    1.标准接口：DataSource  javax.sql下
        1.方法
            *获取连接：getConnection()
            *归还连接：Connection.close() 如果连接对象是从连接池中获取，调用close()就是不再是关闭而是归还连接
        常见有C3P0 和 Druid
     C3P0:
        步骤：
            1.导入jar包 c3p0-0.9.5.2.jar 和 mchange-commons-java-0.2.12.jar
            2.定义配置文件   路径：src路径下   名称：c3p0.properties 或者 c3p0-config.xml
            3.创建核心对象  数据库连接池对象 ComboPooledDataSource
            4.获取连接：getConnection
 */
public class Demo01JdbcPool {
}
