package Demo01;
/*
JDBC 控制事务
    1.开启事务 SetAutoCommit(boolean aotoCommit):调用该方法 当为false即为开启事务
    2.提交事务 commit();
    3.回滚事务 rollback();
    获取到连接之后就可以开启事务了   conn.SetAutoCommit(false)
    执行sql语句之后提交事务       conn.commit();
    在catch异常中进行事物的回滚    conn.rollback();
 */
public class Demo10ShiWu {

}
