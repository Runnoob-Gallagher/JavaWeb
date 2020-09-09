package service.Imple;

import dao.Imple.UserdaoImple;
import dao.Userdao;
import domain.Table_user;
import service.UserService;

import java.util.List;

/**
 * 用以实现UserService接口中的findAll()方法
 * 而这个findAll()方法是由dao层中的方法去获取的
 */
public class UserServiceImple implements UserService {
    //创建对象调用方法,使用的是多态。
    private Userdao dao = new UserdaoImple();
    @Override
    public List<Table_user> findAll() {
        return dao.findAll(); //这里的返回值是要返回到Servlet里去的，所以还需要在Servlet中，创建该类的对象，调用方法获取值
    }
}
