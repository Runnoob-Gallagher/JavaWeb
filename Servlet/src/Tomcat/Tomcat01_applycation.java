package Tomcat;
/*Tomcat部署方式：
    1.直接将项目放到webapps目录下即可：
    2.配置conf/server.xml文件：
        在<HOST>标签体中配置
        <Context docBase="D:\hello" path="/hehe" />
        *docBase:项目存放的路径
        *path：虚拟目录
    3.在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写
        <Context docBase="D:\hello"/>
        *虚拟目录：xml文件的名称*/
public class Tomcat01_applycation {
}
