package com.tw.dao;

import com.tw.entity.User;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/8/15.
 */
@Repository
public class UserDao {

    public List<User> get_users() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务

        String hql = "from User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        session.getTransaction().commit();
        return users;
    }

    public void insert_user(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(user);
        session.getTransaction().commit();
    }

    public void delete_user(int id) {
        User user = new User();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();

    }

    public User get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public void update(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }


    public boolean login_judgement(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        int usrsNum;
        session.beginTransaction();

        Query query = session.createQuery("FROM User user where user.name = ? and user.password = ?");
        query.setString(0, name);
        query.setString(1, MD5EncryptionHelper.stringMD5(password));

        List<User> users = query.list();
        usrsNum = users.size();
        session.getTransaction().commit();

        boolean flag = true;
        if (usrsNum == 1) {
            flag = true;
        }
        return flag;

    }


}
