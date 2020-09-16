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

    @Override
    public Table_user getuserpassword(Table_user table_user) {
        return dao.getuserpass(table_user.getName(),table_user.getPassword());
    }

    @Override
    public void add(Table_user table_user) {
         dao.add(table_user);
    }

    @Override
    public void delUser(String parseIntid) {
        dao.delUser(Integer.parseInt(parseIntid));
    }

    @Override
    public Table_user findUser(String findUserid) {
        return dao.findUser(Integer.parseInt(findUserid));
    }

    @Override
    public void updateTable_user(Table_user table_user) {
        dao.updateUser(table_user);
    }

    @Override
    public void delSelect(String[] uids) {
        for (String uid : uids) {
            dao.delUser(Integer.parseInt(uid));
        }
    }


}
