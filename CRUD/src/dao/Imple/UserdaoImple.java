package dao.Imple;

import dao.Userdao;
import domain.Table_user;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

/**
 * 实现Userdao方法，获取数据库中的数据
 */
public class UserdaoImple implements Userdao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Table_user> findAll() {
        String sql = "select * from table_user";
        List<Table_user> table_user_list = template.query(sql, new BeanPropertyRowMapper<Table_user>(Table_user.class));
        return table_user_list;
    }

    @Override
    public Table_user getuserpass(String username, String password) {
        String sql = "select *from Table_user where username=? and password=?";
        Table_user table_user = template.queryForObject(sql, new BeanPropertyRowMapper<Table_user>((Table_user.class), username, password));
    }


}
