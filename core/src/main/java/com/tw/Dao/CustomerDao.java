package com.tw.dao;

import com.tw.entity.Customer;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/21/15.
 */
@Repository
public class CustomerDao {

    public List<Customer> get_customers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Customer";
        Query query  = session.createQuery(hql);

        List<Customer> customers = query.list();
        session.getTransaction().commit();
        return customers;
    }

    public void insert_customer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(customer);
        session.getTransaction().commit();
    }

    public void delete_customer(int id) {
        Customer customer = new Customer();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        customer.setId(id);
        session.delete(customer);
        session.getTransaction().commit();
    }

    public Customer get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class, id);
        session.getTransaction().commit();
        return customer;
    }

    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }


}
