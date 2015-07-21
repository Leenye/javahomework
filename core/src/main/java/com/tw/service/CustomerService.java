package com.tw.service;

import com.tw.dao.CustomerDao;
import com.tw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/21/15.
 */
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public List<Customer> get_customers() {
        return customerDao.get_customers();
    }
    public void insert_customer(Customer customer) {
        customerDao.insert_customer(customer);
    }

    public void delete_customer(int id) {
        customerDao.delete_customer(id);
    }

    public Customer get_customer_by_id(int id){
        return customerDao.get_element_by_id(id);
    }

    public void update(Customer customer){
        customerDao.update(customer);
    }

}
