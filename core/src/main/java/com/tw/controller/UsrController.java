package com.tw.controller;

import com.tw.entity.Employee;
import com.tw.entity.Usr;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by twer on 7/13/15.
 */
@Controller
@RequestMapping("/user")
public class UsrController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session,HttpServletResponse response) {

        Cookie cookie = new Cookie("lastVisited", "/user");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            return new ModelAndView("user", "usrs", userService.get_users());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name, String gender, int age, String email,String password , int employee_id,
                                   HttpSession sessionHttp,HttpServletResponse response) {
        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/user");
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
           String ps = MD5EncryptionHelper.stringMD5(password);

            Employee employee = employeeService.get_element_by_id(employee_id);

            Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
            session2.beginTransaction();
            Criteria criteria2 = session2.createCriteria(Usr.class);
            criteria2.add(Restrictions.eq("employee", employee));
            List<Usr> list2 = criteria2.list();
            session2.getTransaction().commit();

            if (employee != null&&list2.size()!=1){
                Usr usr = new Usr(name, gender, age, email,ps,employee);
                userService.insert_users(usr);
                return new ModelAndView("redirect:/user");

            }else {
                return new ModelAndView("redirect:/user");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "deleteUsr/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/deleteUsr/"+id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
            userService.delete_user(id);
            return new ModelAndView("redirect:/user");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="updateUsr/{id}",method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id,HttpSession session,HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUsr/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);


        if(loginStatement == "login"){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("userUpdate");
            Usr targetUsr = userService.get_element_by_id(id);
            modelAndView.addObject("usr", targetUsr);
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="updateUsr/{id}",method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, String gender, int age, String email,String password,int employeeId,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUsr/" +id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(loginStatement == "login"){
            Employee emp = employeeService.get_element_by_id(employeeId);
            Usr usr = new Usr(id,name,gender,age,email,password,emp);
            userService.update_user(usr);
            return new ModelAndView("redirect:/user");
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
}
