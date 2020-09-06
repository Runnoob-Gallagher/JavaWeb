package Query;

import Query.dao.Imple.UserDaoImple;
import Query.domain.User;
import Query.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataSource dataSource = JDBCUtils.getDataSource();
      /*  System.out.println(dataSource);
        System.out.println(connection);*/
        UserDaoImple ud = new UserDaoImple();
        List<User> all = ud.findAll();
        System.out.println(all);
    }
}
