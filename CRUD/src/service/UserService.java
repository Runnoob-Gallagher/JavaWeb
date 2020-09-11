package service;

import domain.Table_user;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 用于处理业务逻辑
     */
    public List<Table_user> findAll();
    public Table_user getuserpassword(String username,String password);
}
