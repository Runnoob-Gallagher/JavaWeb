package Test;

import Login.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;


public class BeanTest {
    @Test   //这个要定义在方法之上
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"gender","male");//User{id=0, username='null', password='null', gender='null'}  直接操作成员变量没有值
            BeanUtils.setProperty(user,"hehe","male");//User{id=0, username='null', password='null', gender='male'}
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);//User{id=0, username='null', password='null', gender='null'}  直接操作成员变量没有值
    }
}
//这个例子说明操作的是属性