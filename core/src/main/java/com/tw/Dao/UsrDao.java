package com.tw.dao;

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
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "from Usr";
        Query query  = session.createQuery(hql);
        List<Usr> usrs = query.list();

        session.close();
        return usrs;
    }

    public void insert_usr(Usr usr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(usr);
        session.getTransaction().commit();
        session.close();
    }

    public void delete_usr(int id){
        Usr usr = new Usr();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务
        usr.setId(id);
        session.delete(usr);
        session.getTransaction().commit();
        session.close();

    }

    public Usr get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usr usr = (Usr) session.get(Usr.class,id);
        session.close();
        return usr;
    }

    public void update(Usr usr){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务
        session.update(usr);
        session.getTransaction().commit();
        session.close();
    }

    public boolean login_judgement(String name, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();//开启操作数据库的事务

//        String sql = "select * from Usr usr where usr.name = :name and user.password = :password";
        Query query = session.createQuery("FROM Usr usr where usr.name = :name and usr.password = :password");
        query.setParameter("name",name);
        query.setParameter("password",password);
        List<Usr> usrs = query.list();
        int usrsNum = usrs.size();
        session.close();
        if (usrsNum == 1){
            return true;
        }else {
            return false;
        }
    }

}
