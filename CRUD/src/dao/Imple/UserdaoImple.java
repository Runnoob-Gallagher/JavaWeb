package dao.Imple;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
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
        try {
            String sql = "select * from table_user where username=? and password=?";
            Table_user table_user = template.queryForObject(sql, new BeanPropertyRowMapper<Table_user>(Table_user.class), username, password);
            return table_user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(Table_user table_user) {
        String sql = "insert into table_user value(null,?,?,?,?,?,?,null,null)";
        template.update(sql,table_user.getXM(),table_user.getGender(),table_user.getAge(),table_user.getAddress(),table_user.getQq(),table_user.getEmail());
    }

    @Override
    public void delUser(int parseIntid) {
        String sql = "delete from table_user where id = ?";
        template.update(sql,parseIntid);
    }

    @Override
    public Table_user findUser(int parseInt) {
        String sql = "select * from table_user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Table_user>(Table_user.class),parseInt);
    }

    @Override
    public void updateUser(Table_user table_user) {
        String sql = "update table_user set XM=?, gender=?, age=?, address=?, qq=?, email=? where id=?;";
        template.update(sql,table_user.getXM(),table_user.getGender(),table_user.getAge(),table_user.getAddress(),table_user.getQq(),table_user.getEmail(),table_user.getId());
    }


}
