package com.tw.dao;

import com.tw.helper.MD5EncryptionHelper;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;


import com.tw.entity.Usr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/8/15.
 */
@Repository
public class UsrDao {

    public List<Usr> get_usrs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务

        String hql = "from Usr";
        Query query = session.createQuery(hql);
        List<Usr> usrs = query.list();
        session.getTransaction().commit();
        return usrs;
    }

    public void insert_usr(Usr usr) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(usr);
        session.getTransaction().commit();
    }

    public void delete_usr(int id) {
        Usr usr = new Usr();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        usr.setId(id);
        session.delete(usr);
        session.getTransaction().commit();

    }

    public Usr get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Usr usr = (Usr) session.get(Usr.class, id);
        session.getTransaction().commit();
        return usr;
    }

    public void update(Usr usr) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(usr);
        session.getTransaction().commit();
    }


    public boolean login_judgement(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        int usrsNum;
        session.beginTransaction();

        Query query = session.createQuery("FROM Usr usr where usr.name = ? and usr.password = ?");
        query.setString(0, name);
        query.setString(1, MD5EncryptionHelper.stringMD5(password));

        List<Usr> usrs = query.list();
        usrsNum = usrs.size();
        session.getTransaction().commit();

        boolean flag = false;
        if (usrsNum == 1) {
            flag = true;
        }
        return flag;

    }


}
