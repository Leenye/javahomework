package com.tw.service;

import com.tw.dao.EmployeeDao;
import com.tw.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/19/15.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> get_employees() {
        return employeeDao.get_employees();
    }


}
