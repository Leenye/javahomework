package com.tw.controller;

import com.tw.entity.Coach;
import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.Schema;
import com.tw.service.CoachService;
import com.tw.service.CourseService;
import com.tw.service.EmployeeService;
import com.tw.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/schema")
public class SchemaController {

    @Autowired
    CourseService courseService;
    @Autowired
    CoachService coachService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SchemaService schemaService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getSchemas(HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/schema");
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("schema");
            List<Schema> schemas = schemaService.get_schemas();
            List<Coach> employees = coachService.get_coaches();
            List<Course> courses = courseService.get_courses();
            modelAndView.addObject("schemas", schemas);
            modelAndView.addObject("courses", courses);
            modelAndView.addObject("employees", employees);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
//    public void insertSchema(@RequestParam int course_id, int coach_id, String time, String customer,
//                                     HttpSession session1, HttpServletResponse response) {
//        Cookie cookie = new Cookie("lastVisited", "/schema");
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        String loginStatement = (String) session1.getAttribute("loginStatement");
//        if (loginStatement == "login" && schemaService.validationCheck(coach_id, time) ) {
//                Employee employee = employeeService.get_element_by_id(coach_id);
//                Course course = courseService.get_element_by_id(course_id);
//                Schema schema = new Schema(course, employee, time, customer);
//                schemaService.insert_schema(schema);
//        }
//    }
    public ModelAndView insertSchema(@RequestParam int course_id, int coach_id, String time, String customer,
                                     HttpSession session1, HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/schema");
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session1.getAttribute("loginStatement");
        if (loginStatement == "login") {
            if (schemaService.validationCheck(coach_id, time)) {
                Employee employee = employeeService.get_element_by_id(coach_id);
                Course course = courseService.get_element_by_id(course_id);
                Schema schema = new Schema(course, employee, time, customer);
                schemaService.insert_schema(schema);
                return new ModelAndView("redirect:/schema");
            } else {
                return new ModelAndView("redirect:/schema");
            }
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/deleteSchema/{id}", method = RequestMethod.DELETE )
//    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody  String deleteSchema(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/schema");
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            schemaService.delete_schema(id);
            return "ok";
        }
        return null;
    }


    @RequestMapping(value = "/updateSchema/{id}", method = RequestMethod.GET)
    public @ResponseBody Schema getElementById(@PathVariable int id, HttpSession session, HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/schema/updateSchema/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session.getAttribute("loginStatement");
        Schema schema = new Schema();
        if (loginStatement == "login") {
            schema = schemaService.get_element_by_id(id);
        }
        return schema;
    }

    @RequestMapping(value = "/updateSchema/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateSchema(@PathVariable int id, @RequestParam int course_id, int coach_id, String time, String customer,
                             HttpSession session, HttpServletResponse response) {
        System.out.println(id+course_id+"++++++++++++++++++++++++");
        Cookie cookie = new Cookie("lastVisited", "/schema");
        cookie.setPath("/");
        response.addCookie(cookie);
        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            Course course = courseService.get_element_by_id(course_id);
            Employee employee = employeeService.get_element_by_id(coach_id);
            Schema schema = new Schema(id, course, employee, time, customer);
            schemaService.update_schema(schema);
        }
    }

//    public ModelAndView updateSchema(@PathVariable int id, @RequestParam int course_id, int coach_id, String time, String customer,
//                                   HttpSession sessionHttp, HttpServletResponse response) {
//        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
//        Cookie cookie = new Cookie("lastVisited", "/schema/updateSchema/" + id);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        if (loginStatement == "login") {
//            if (schemaService.validationCheck(coach_id, time)) {
//                Course course = courseService.get_element_by_id(course_id);
//                Employee employee = employeeService.get_element_by_id(coach_id);
//                Schema schema = new Schema(id, course, employee, time, customer);
//                schemaService.update_schema(schema);
//                return new ModelAndView("redirect:/schema");
//            } else {
//                return new ModelAndView("redirect:/schema");
//            }
//        } else {
//            return new ModelAndView("redirect:/login");
//        }
//    }


//        @RequestMapping(value = "/search",method = RequestMethod.POST)
//        public ModelAndView searchCourse(@RequestParam String time,int coach_id,
//                                         HttpSession sessionHttp,HttpServletResponse response) {
//            Cookie cookie = new Cookie("lastVisited", "/course");
//            cookie.setPath("/");
//            response.addCookie(cookie);
//
//            String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
//            if (loginStatement == "login") {
//
//                Employee employee = employeeService.get_element_by_id(coach_id);
//
//                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//                session.beginTransaction();
//                Criteria criteria = session.createCriteria(Course.class);
//                criteria.add(Restrictions.eq("employee", employee));
//                criteria.add(Restrictions.eq("time", time));
//                List<Course> list = criteria.list();
//                session.getTransaction().commit();
//
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("course");
//                modelAndView.addObject("resultCourse", list);
//                return modelAndView;
//
//            } else {
//                return new ModelAndView("redirect:/login");
//            }
//        }


}
