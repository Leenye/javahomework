package com.tw.dao;

import com.tw.entity.Employee;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/19/15.
 */
@Repository
public class EmployeeDao {

    public List<Employee> get_employees() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务

        Employee employee = (Employee) session.load(Employee.class, 1);
        System.out.println(employee.getRole()+ "------------");
        List<Employee> employees = session.createQuery("from Employee").list();
        session.getTransaction().commit();
        return employees;
    }

    public void insert_employee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(employee);
        session.getTransaction().commit();
    }

    public void delete_employee(int id) {
        Employee employee = new Employee();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        employee.setId(id);
        session.delete(employee);
        session.getTransaction().commit();
    }

    public Employee get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, id);
        session.getTransaction().commit();
        return employee;
    }

    public void update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }





}
