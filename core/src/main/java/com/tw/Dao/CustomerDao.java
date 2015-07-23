package com.tw.dao;

import com.tw.entity.Customer;
import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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


//    public boolean validationCheck(int employee_id){
//        Employee emplolyee = new Employee();
//
//
//        Session session1 = HibernateUtil.getSessionFactory().getCurrentSession();
//        session1.beginTransaction();
//        Criteria criteria = session1.createCriteria(Employee.class);
//        criteria.add(Restrictions.eq("employee", employee));
//        List<Employee> list1 = criteria.list();
//        session1.getTransaction().commit();
//
//        User user = new User();
//        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
//        session2.beginTransaction();
//        Criteria criteria = session2.createCriteria(User.class);
//        criteria.add(Restrictions.eq("employee", employee));
//        List<Employee> list2 = criteria.list();
//        session2.getTransaction().commit();
//
//        boolean flag = false;
//        if (list1.size() == 1 && list2.size() == 0){
//            flag = true;
//        }
//        return flag;
//    }


}
