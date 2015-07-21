package com.tw.controller;

import com.tw.entity.Customer;
import com.tw.entity.Employee;
import com.tw.service.CustomerService;
import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by twer on 7/21/15.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getCustomers(HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/customer");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            return new ModelAndView("customer", "customers", customerService.get_customers());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView insertCustomer(@RequestParam String name,int coach_id,
                                     HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/customer");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {

            Employee emp = employeeService.get_element_by_id(coach_id);
            Customer customer = new Customer(name,emp);
            customerService.insert_customer(customer);
            return new ModelAndView("redirect:/customer");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/deleteCustomer/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable int id,
                                     HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/customer");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            customerService.delete_customer(id);
            return new ModelAndView("redirect:/customer");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="/updateCustomer/{id}",method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id,HttpSession session,HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/customer/updateCustomer/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if(loginStatement == "login"){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("customerUpdate");
            Customer customer =customerService.get_customer_by_id(id);
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="/updateCustomer/{id}",method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, int coach_id,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/customer/updateCustomer/" +id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(loginStatement == "login"){
            Employee emp = employeeService.get_element_by_id(coach_id);
            Customer customer = new Customer(id,name,emp);
            customerService.update(customer);
            return new ModelAndView("redirect:/customer");
        }else{
            return new ModelAndView("redirect:/login");
        }
    }



}
