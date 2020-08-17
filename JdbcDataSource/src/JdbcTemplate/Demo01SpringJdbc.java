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
        *queryForList():查询结果集将结果集封装为List集合
        *query():查询结果，将结果封装欸JavaBean对象
        *queryForObject:查询结果，将结果集封装为对象
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
