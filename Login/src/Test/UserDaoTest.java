package Test;

import Dao.UserDao;
import Login.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("Gallagher");
        loginuser.setPassword("Runnoob");

        UserDao ud = new UserDao();
        User login = ud.login(loginuser);
        System.out.println(login);
    }
}
