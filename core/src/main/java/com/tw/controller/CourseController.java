package com.tw.controller;

import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.service.CourseService;
import com.tw.service.EmployeeService;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
import java.util.List;

/**
 * Created by twer on 7/19/15.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getCourses(HttpSession session,HttpServletResponse response) {

        Cookie cookie = new Cookie("lastVisited", "/course");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {

            return new ModelAndView("course", "courses", courseService.get_courses());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView insertCourse(@RequestParam String name,String time,int coach_id,
                                       HttpSession sessionHttp,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/course");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        if (loginStatement == "login") {

            Employee employee = employeeService.get_element_by_id(coach_id);

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Course.class);
            criteria.add(Restrictions.eq("employee", employee));
            criteria.add(Restrictions.eq("time",time));
            List<Course> list = criteria.list();
            session.getTransaction().commit();



            if (list.size() == 0){
                Course course = new Course(name,time,employee);
                courseService.insert_course(course);
                return new ModelAndView("redirect:/course");

            }else{

                return new ModelAndView("redirect:/course");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/deleteCourse/{id}",method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable int id,
                                       HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/course");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            courseService.delete_course(id);
            return new ModelAndView("redirect:/course");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    @RequestMapping(value="/updateCourse/{id}",method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id,HttpSession session,HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/course/updateCourse/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if(loginStatement == "login"){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("courseUpdate");
            Course course =courseService.get_element_by_id(id);
            modelAndView.addObject("course", course);

            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="/updateCourse/{id}",method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, @RequestParam String name,  @RequestParam String time,  @RequestParam int coach_id,
                                   HttpSession sessionHttp,HttpServletResponse response) {
        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/course/updateCourse/" +id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(loginStatement == "login"){

            Employee employee = employeeService.get_element_by_id(coach_id);

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Course.class);
            criteria.add(Restrictions.eq("employee", employee));
            criteria.add(Restrictions.eq("time",time));
            List<Course> list = criteria.list();
            session.getTransaction().commit();

            if (list.size() == 0){
                Course course = new Course(id,name,time,employee);
                courseService.update_course(course);
                return new ModelAndView("redirect:/course");

            }else{

                return new ModelAndView("redirect:/course");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView searchCourse(@RequestParam String time,int coach_id,
                                     HttpSession sessionHttp,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/course");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        if (loginStatement == "login") {

            Employee employee = employeeService.get_element_by_id(coach_id);

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Course.class);
            criteria.add(Restrictions.eq("employee", employee));
            criteria.add(Restrictions.eq("time", time));
            List<Course> list = criteria.list();
            session.getTransaction().commit();

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("course");
            modelAndView.addObject("resultCourse", list);
            return modelAndView;

        } else {
            return new ModelAndView("redirect:/login");
        }
    }

}
