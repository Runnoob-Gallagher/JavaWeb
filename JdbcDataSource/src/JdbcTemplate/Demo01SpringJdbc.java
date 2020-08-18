package JdbcTemplate;

import DataSource.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
Spring JDBC :Spring对jdbc的简单封装
步骤：
    1.导入jar包
    2.创建JdbcTemplate对象。依赖与数据源DataSource
          JdbcTemplate template = new JdbcTemplate(DataSource ds);
    3.调用JdbcTemplate中的方法惊醒CRUD
        *update():执行DML语句。
        *queryDorMap()：查询结果将结果集封装为Map集合
            注意：这个方法将列名作为key，将值作为value，然后将记录封装为一个map集合中。存入的集合长度只能为1.即一行数据
        *queryForList():查询结果集将结果集封装为List集合
            注意：将每一条记录封装为一个Map集合，然后再将所有的map集合转载到list集合中
        *query():查询结果，将结果封装欸JavaBean对象
            注意：可以自己手动赋值导入，也可以是使用RowMapper参数，需要实现BeanPropertyRowMapper实现类。自动完成JavaBean的很好赚
                 List<EmpObject> list = jdbctemplate.query(sql, new BeanPropertyRowMapper<EmpObject>(EmpObject.class));
                 new BeanPropertyRowMapper<类型>(类型.class)   结合反射
        *queryForObject:查询结果，将结果集封装为对象
            注意：一般用以聚合函数的查询
 */
public class Demo01SpringJdbc {
        //导入jar包
        //创建JdbcTemplate对象
    public static void main(String[] args) {
        JdbcTemplate jdbctemplate = new JdbcTemplate(DruidUtils.getdatasource());
        //调用方法
        String sql = "update login set username = 'SevenHappy' where id = ? ";
        int count = jdbctemplate.update(sql, 3);
        System.out.println(count);
    }
}
