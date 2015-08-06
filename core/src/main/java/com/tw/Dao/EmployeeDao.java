package com.tw.dao;

import com.tw.entity.Employee;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by twer on 7/19/15.
 */
@Repository
@EnableTransactionManagement
//@Transactional
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Employee> get_employees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = session.createQuery("from Employee").list();
        return employees;
    }

    public void insert_employee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    public void delete_employee(int id) {
        Session session = sessionFactory.getCurrentSession();

//        Employee employee = new Employee();
//        employee.setId(id);
        Employee employee = (Employee) session.get(Employee.class,id);
        session.delete(employee);
    }

    public Employee get_element_by_id(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, id);
        return employee;
    }

    public void update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }



}
