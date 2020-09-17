package service;

import domain.PageBean;
import domain.Table_user;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 用于处理业务逻辑
     */
    public List<Table_user> findAll();

    public Table_user getuserpassword(Table_user table_user);


    public void add(Table_user table_user);

    public void delUser(String parseIntid);


    public Table_user findUser(String findUserid);


    void updateTable_user(Table_user table_user);

    void delSelect(String[] uids);

    PageBean<Table_user> getPageBean(String currentPage, String rows, Map<String, String[]> condition);
}
