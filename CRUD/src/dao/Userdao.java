package dao;

import domain.Table_user;

import java.util.List;

/**
 * 用户操作的dao
 */
public interface Userdao {
    public List<Table_user> findAll();
}
