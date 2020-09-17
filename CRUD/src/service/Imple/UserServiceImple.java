package service.Imple;

import dao.Imple.UserdaoImple;
import dao.Userdao;
import domain.PageBean;
import domain.Table_user;
import service.UserService;

import java.util.List;
import java.util.Map;

/**
 * 用以实现UserService接口中的findAll()方法
 * 而这个findAll()方法是由dao层中的方法去获取的
 */
public class UserServiceImple implements UserService {
    //创建对象调用方法,使用的是多态。
    private Userdao dao = new UserdaoImple();
    @Override
    public List<Table_user> findAll() {
        return dao.findAll(); //这里的返回值是要返回到Servlet里去的，所以还需要在Servlet中，创建该类的对象，调用方法获取值
    }

    @Override
    public Table_user getuserpassword(Table_user table_user) {
        return dao.getuserpass(table_user.getName(),table_user.getPassword());
    }

    @Override
    public void add(Table_user table_user) {
         dao.add(table_user);
    }

    @Override
    public void delUser(String parseIntid) {
        dao.delUser(Integer.parseInt(parseIntid));
    }

    @Override
    public Table_user findUser(String findUserid) {
        return dao.findUser(Integer.parseInt(findUserid));
    }

    @Override
    public void updateTable_user(Table_user table_user) {
        dao.updateUser(table_user);
    }

    @Override
    public void delSelect(String[] uids) {
        for (String uid : uids) {
            dao.delUser(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<Table_user> getPageBean(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        if(currentPage <= 0){
            currentPage = 1;
        }
        int rows = Integer.parseInt(_rows);
        //创建一个PageBean对象
        PageBean<Table_user> pageBean = new PageBean<>();
        //将传递过来的值用上
        //pageBean.setCurrentPage(currentPage);  这个我放后面去了
        pageBean.setRows(rows);
        //调用dao查询总记录数
        int totalCount = dao.findtotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用dao查询list集合
        int start = (currentPage - 1) * rows;
        //因为是条件查询也需要加上参数condition
        List<Table_user> Table_user_list = dao.FindByPage(start,rows,condition);//返回是一个List集合类型
        pageBean.setList(Table_user_list);
//        System.out.println(Table_user_list);
        //总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows) + 1;
//        System.out.println(totalPage + "yyyyyy");
        if(currentPage >= totalPage){
            currentPage = totalPage;
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;

    }


}
