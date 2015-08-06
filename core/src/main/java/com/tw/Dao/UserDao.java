package com.tw.dao;

import com.tw.entity.User;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by twer on 7/8/15.
 */
@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> get_users() {
        Session session = sessionFactory.getCurrentSession();

        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        return users;
    }

    public void insert_user(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void delete_user(int id) {
        User user = new User();
        Session session = sessionFactory.getCurrentSession();
        user.setId(id);
        session.delete(user);

    }

    public User get_element_by_id(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }


    public boolean login_judgement(String name, String password) {
        Session session = sessionFactory.getCurrentSession();
        int usrsNum;

        Query query = session.createQuery("FROM User user where user.name = ? and user.password = ?");
        query.setString(0, name);
        query.setString(1, MD5EncryptionHelper.stringMD5(password));

        List<User> users = query.list();
        usrsNum = users.size();

        boolean flag = true;
        if (usrsNum == 1) {
            flag = true;
        }
        return flag;

    }


}
