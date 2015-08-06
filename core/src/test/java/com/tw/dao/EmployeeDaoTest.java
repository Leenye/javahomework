package com.tw.dao;

import com.tw.entity.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class EmployeeDaoTest {

    @BeforeClass
    public static void setProperty(){
        System.setProperty("jdbc.active.database","test");
    }

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGet_employees() throws Exception {
        List<Employee> employees = employeeDao.get_employees();
        assertEquals(employees.size(), 5);
    }

    @Test
    public void testInsert_employee() throws Exception {
        Employee employee =new Employee("hello","M",10,"111@123","OP","ON");
        employeeDao.insert_employee(employee);

        List<Employee> employees = employeeDao.get_employees();
        assertEquals(employees.size(),6);
    }

    @Test
    public void testDelete_employee() throws Exception {
        employeeDao.delete_employee(1);

        List<Employee> employees = employeeDao.get_employees();
        assertEquals(employees.size(),4);

    }

    @Test
    public void testGet_element_by_id() throws Exception {
        Employee employee = employeeDao.get_element_by_id(1);
        assertEquals(employee.getName(),"lily");
    }

    @Test
    public void testUpdate() throws Exception {
        Employee employee = new Employee(1,"lucy","M",16,"hello","HR","OFF");
        employeeDao.update(employee);

        List<Employee> employees = employeeDao.get_employees();

        assertEquals(employees.get(0),employee);


    }
}