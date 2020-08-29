package Dao;

import Login.User;
import Utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
操作数据库中User表的类
 */
public class UserDao {
    //声明JDBCTemplate对象公用
    private JdbcTemplate tmplate = new JdbcTemplate(JdbcUtils.getDataSource());
    /**
     *
     * @param loginuser  需要用户名和密码
     * @return  返回User包含的全部数据
     */

    public User login(User loginuser){
        try {
            //编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User user = tmplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),loginuser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
