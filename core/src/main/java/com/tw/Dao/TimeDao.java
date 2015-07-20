package com.tw.dao;

import com.tw.entity.Time;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/18/15.
 */
@Repository
public class TimeDao {

    public List<Time> get_time() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务

        String hql = "from Time";
        Query query  = session.createQuery(hql);
        List<Time> time = query.list();
        session.getTransaction().commit();

        return time;
    }

    public void insert_time(Time time){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(time);
        session.getTransaction().commit();
    }

    public void delete_time(int time_id){
        Time time = new Time();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        time.setTime_id(time_id);
        session.delete(time);
        session.getTransaction().commit();
    }



}
