package com.tw.controller;

import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.service.EmployeeService;
import com.tw.service.UserService;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by twer on 7/13/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
        public List<User> getUsers(HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/user");
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session.getAttribute("loginStatement");
        List<User> users = userService.get_users();
        return users;
    }


//    public ModelAndView getUsers(HttpSession session, HttpServletResponse response) {
//        Cookie cookie = new Cookie("lastVisited", "/user");
//        cookie.setPath("/");
//        response.addCookie(cookie);
//
//        String loginStatement = (String) session.getAttribute("loginStatement");
//        if (loginStatement == "login") {
//            return new ModelAndView("user", "users", userService.get_users());
//        } else {
//            return new ModelAndView("redirect:/login");
//        }
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name, String password, int employee_id,
                                   HttpSession sessionHttp, HttpServletResponse response) {
        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/user");
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            String ps = MD5EncryptionHelper.stringMD5(password);
            Employee employee = employeeService.get_element_by_id(employee_id);

            if (userService.validationCheck(employee_id)) {
                User user = new User(name, ps, employee);
                userService.insert_users(user);
                return new ModelAndView("redirect:/user");

            } else {
                return new ModelAndView("redirect:/user");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/deleteUser/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            userService.delete_user(id);
            return new ModelAndView("redirect:/user");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id, HttpSession session, HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUser/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("userUpdate");
            User targetUser = userService.get_element_by_id(id);
            modelAndView.addObject("user", targetUser);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, String password, int employee_id,
                                   HttpSession session, HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUser/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            if (userService.validationCheck(employee_id)) {
                Employee emp = employeeService.get_element_by_id(employee_id);
                User user = new User(id, name, password, emp);
                userService.update_user(user);
                return new ModelAndView("redirect:/user");
            } else {
                return new ModelAndView("redirect:/user");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }
}
