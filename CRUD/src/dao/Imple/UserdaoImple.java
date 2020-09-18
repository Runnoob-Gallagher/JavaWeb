package dao.Imple;

import dao.Userdao;
import domain.Table_user;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public int findtotalCount(Map<String, String[]> condition) {
        //定义模板SQL
        String sql = "select count(*) from table_user where 1=1 ";
        //定义一个StringBuilder来拼接sql
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();  //获取所有的key,指name email 等等
        //定义一个参数的集合，就是用来存储name emails等的指
        List<Object> list = new ArrayList<>();
        //通过key遍历value
        for (String values : keySet) {
            //排除分页条件参数
            if("currentPage".equals(values) || "rows".equals(values)){
                continue;
            }
            String value = condition.get(values)[0];//因为条件框中只会存在一个条件
            //判断value是否为空，不为空的话就追加 查询条件
            if(!"".equals(value) && value != null){
                stringBuilder.append(" and "+ values +" like ? ");
                list.add("'%" + value + "%'"); //这个就代表了？的值
            }
        }
        System.out.println(stringBuilder + "  " +"sql");
        System.out.println(list + "  " +"list");
        return template.queryForObject(stringBuilder.toString(),Integer.class,list.toArray());  //这个没太懂,后面接可变参数
    }

    @Override
    public List<Table_user> FindByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from table_user where 1 = 1 ";
        //定义一个StringBuilder来拼接sql
        StringBuilder stringBuilder = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();  //获取所有的key,指name email 等等
        //定义一个参数的集合，就是用来存储name emails等的指
        List<Object> list = new ArrayList<Object>();
        //通过key遍历value
        for (String values : keySet) {
            String value = condition.get(values)[0];//因为条件框中只会存在一个条件
            //判断value是否为空，不为空的话就追加 查询条件
            if(!"".equals(value) && value != null){
                stringBuilder.append(" and "+ values +" like ? ");
                list.add("'%" + value + "%'"); //这个就代表了？的值
            }
        }
        //因为是分页查询，还要加条件
        stringBuilder.append(" limit ? , ?");
        list.add(start);
        list.add(rows);
        System.out.println(list.toArray() + "asdasd");
        System.out.println(stringBuilder.toString() + "asdaddddddd");
        return template.query(stringBuilder.toString(),new BeanPropertyRowMapper<Table_user>(Table_user.class),list.toArray());
    }
}
