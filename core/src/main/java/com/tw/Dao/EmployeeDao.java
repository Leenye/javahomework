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

//        String hql = "from Employee";
//        Query query  = session.createQuery(hql);
//        List<Employee> employees = query.list();
//        Employee employee = (Employee) session.load(Employee.class, 1);
//        System.out.println(employee.getRole()+ "------------");
        List<Employee> employees = session.createQuery("from Employee").list();
        session.getTransaction().commit();
        return employees;
    }

}
