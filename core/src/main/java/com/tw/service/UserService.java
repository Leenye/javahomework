package com.tw.service;

import com.tw.dao.EmployeeDao;
import com.tw.dao.UserDao;
import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<User> get_users() {
        return userDao.get_users();
    }

    public void insert_users(User user) {
        userDao.insert_user(user);
    }

    public void delete_user(int id) {
        userDao.delete_user(id);
    }

    public User get_element_by_id(int id) {
        return userDao.get_element_by_id(id);
    }

    public void update_user(User user){
        userDao.update(user);
    }

    public boolean login_judgement(String name, String password) {
        return userDao.login_judgement(name, password);
    }

    public boolean validationCheck(int employee_id){
        Employee employee = employeeDao.get_element_by_id(employee_id);
        boolean flag = false;
        if ( employee != null ){

            Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
            session2.beginTransaction();
            Criteria criteria2 = session2.createCriteria(User.class);
            criteria2.add(Restrictions.eq("employee", employee));
            List<Employee> list2 = criteria2.list();
            session2.getTransaction().commit();
            if(list2.size()==0){
                flag = true;

            }
        }
        return flag;
    }


}