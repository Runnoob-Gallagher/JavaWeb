package JdbcTemplate;

import DataSource.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo02DMLPractice {
    //因为这个创建JdbcTemplate对象太过麻烦且重复率很高，就直接定义为私有静态成员变量
    private static JdbcTemplate jdbctemplate = new JdbcTemplate(DruidUtils.getdatasource());
    //修改1号数据sqlary为10000；
    @Test
    public void change(){
        //导入jar包
        //创建JdbcTemplate对象，依赖数据源DataSource
        String sql = "update emp set salary = 10000.00 where id =  1001";
        //String sql = "update emp set salary = 10000.00 where id = ?"
        //int count = jdbctemplate.update(sql,1001);
        int count = jdbctemplate.update(sql);
        System.out.println(count);
    }
    @Test
    public void insert(){
        String sql = "insert into emp  values (?,?,?,?,?,?,?,?)";
        int count = jdbctemplate.update(sql, 1090, "Gallagher", 1, 2020, "2020-08-18", 30000.00, 13000.00, 10);
        System.out.println(count);
    }
    @Test
    public void delete(){
        String sql = "delete from emp where id = ?";
        int count = jdbctemplate.update(sql, 1090);
        System.out.println(count);
    }
    @Test
    public void querymapA(){ //queryForMap这个查询的结果集只能是1，不能有多个。查询结果为列作为key，值作为value。封装为map集合
        String sql = "select * from emp where id = ?";
        Map<String, Object> map = jdbctemplate.queryForMap(sql,1001);
        System.out.println(map);//{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}
    }
    @Test
    public void querylist(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = jdbctemplate.queryForList(sql);
        System.out.println(list);//看他的返回值：List<Map<String, Object>>，将每一条记录封装为map集合然后封装在list集合中
    }
    @Test
    public void querymapB(){
        String sql = "select * from emp";
        List<EmpObject> list = jdbctemplate.query(sql, new RowMapper<EmpObject>() { //返回一个list集合
            //总结：这个一个接口，实现类返回的是对象，且会返回ResultSet结果集。按照之前的返回，将结果集中的值通过对象的set方法赋值写入到对象中，实现类返回这个对象，接口返回list集合，最后遍历这个集合。
            @Override
            public EmpObject mapRow(ResultSet resultSet, int i) throws SQLException { //这个实现类没写一次就会封装一个EmpObject对象，根据结果集对象ResultSet获取结果
                EmpObject eo = new EmpObject();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                eo.setBonus(bonus);
                eo.setDept_id(dept_id);
                eo.setEname(ename);
                eo.setId(id);
                eo.setJoindate(joindate);
                eo.setMgr(mgr);
                eo.setSalary(salary);
                eo.setJob_id(job_id);
                return eo;
            } //匿名内部类，实现这个接口
        });
        for (EmpObject eo: list) {
            System.out.println(eo);
        }

    }
    @Test
    public void querymapC(){
        String sql = "select * from emp";
        List<EmpObject> list = jdbctemplate.query(sql, new BeanPropertyRowMapper<EmpObject>(EmpObject.class));
        for (EmpObject emp:list) {
            System.out.println(emp);//Failed to convert property value of type 'null' to required type 'double' for property 'bonus';
            //这里报错，是因为无法进行转换  比如基本类型int不能接受null，也就无法转换。要将基本数据类型转换为引用数据类型
        }

    }
    @Test
    public void sum(){
        String sql = " select count(*) from emp";
        Long count = jdbctemplate.queryForObject(sql, long.class); //queryForObject(String sql.Class<T> requiredType)
        System.out.println(count);
    }
}
