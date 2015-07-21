package com.tw.controller;

import com.tw.entity.Employee;
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
 * Created by twer on 7/19/15.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getEmployees(HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/employee");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            return new ModelAndView("employee", "employees", employeeService.get_employees());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView insertEmployee(@RequestParam String name,String role,String statement,
                                       HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/employee");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            Employee employee = new Employee(name,role,statement);
            employeeService.insert_employee(employee);
            return new ModelAndView("redirect:/employee");
        } else {
            return new ModelAndView("redirect:/login");
        }

    }

    @RequestMapping(value = "/deleteEmployee/{id}",method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable int id,
                                       HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/employee");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            employeeService.delete_employee(id);
            return new ModelAndView("redirect:/employee");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    @RequestMapping(value="updateEmployee/{id}",method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id,HttpSession session,HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "employee/updateEmployee/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if(loginStatement == "login"){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("employeeUpdate");
            Employee employee = employeeService.get_element_by_id(id);
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="updateEmployee/{id}",method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, String role, String statement,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "employee/updateEmployee/" +id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(loginStatement == "login"){
            Employee employee = new Employee(id,name,role,statement);
            employeeService.update(employee);
            return new ModelAndView("redirect:/employee");
        }else{
            return new ModelAndView("redirect:/login");
        }
    }







}
