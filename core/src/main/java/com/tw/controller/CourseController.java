package com.tw.controller;

import com.tw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by twer on 7/19/15.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getCourses(HttpSession session,HttpServletResponse response) {
        System.out.println("进入course controller————————————————————");

        Cookie cookie = new Cookie("lastVisited", "/courseTime");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            System.out.println("对course处理＋＋＋＋＋＋＋＋＋＋＋＋＋");


            return new ModelAndView("course", "courses", courseService.get_courses());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

}
