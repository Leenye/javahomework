package com.tw.dao;

import com.tw.entity.Coach;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/22/15.
 */
@Repository
public class CoachDao {
    public List<Coach> get_coaches() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务

        List<Coach> coaches = session.createQuery("from Employee E where E.role = 'coach'").list();
        session.getTransaction().commit();
        return coaches;
    }

}
