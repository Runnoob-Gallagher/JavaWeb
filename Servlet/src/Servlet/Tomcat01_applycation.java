package Servlet;

/*Tomcat部署方式：
    1.直接将项目放到webapps目录下即可：
        *   /usr/local/apache-tomcat-7.0.70/webapps/html/table.html
        *   简化部署，直接将html文件打成war包
    2.配置conf/server.xml文件：
        在<HOST>标签体中配置
        <Context docBase="D:\hello" path="/hehe" />
        *docBase:项目存放的路径
        *path：浏览器需要填写的虚拟目录
        <Context docBase="/usr/local/apache-tomcat-7.0.70/app" path="/app" />
        http://39.98.137.124:8080/app/table.html
    3.在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写
        <Context docBase="/usr/local/apache-tomcat-7.0.70/app"/>
        *虚拟目录：xml文件的名称
        /usr/local/apache-tomcat-7.0.70/conf/Catalina/localhost/abb.xml
        http://39.98.137.124:8080/abb/table.html*/
/*
java动态项目目录结构：
        --WEB-INF目录：
            --web.xml:web项目的核心配置文件
            --classes目录：放置字节码文件的目录
            --lib目录：放置依赖依赖的jar
 */
public class Tomcat01_applycation {

}
