package dao;

import domain.Table_user;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface Userdao {
    //这个是获取table_users表中的所有对象
    public List<Table_user> findAll();

    //这个是获取table_sers表中的username和password。但是为了使用其中的setter和getter方法，就要设置为改javabean对象
    public Table_user getuserpass(String username,String password);
}
