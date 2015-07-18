package com.tw.controller;

import com.tw.entity.Time;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.service.TimeService;
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
 * Created by twer on 7/18/15.
 */
@Controller
@RequestMapping("/courseTime")
public class TimeController {

    @Autowired
    TimeService timeService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getTime(HttpSession session,HttpServletResponse response) {
        System.out.println("进入curse time controller+++++++++++");
        Cookie cookie = new Cookie("lastVisited", "/courseTime");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {

            System.out.println(timeService.get_time().toString());
            return new ModelAndView("courseTime", "time", timeService.get_time());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView insertTime(@RequestParam String time,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited","/courseTime");
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
            Time time1 = new Time(time);
            timeService.insert_time(time1);
            return new ModelAndView("redirect:/courseTime");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/deleteTime/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable int time_id, HttpSession session, HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/deleteTime/"+time_id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
            timeService.delete_time(time_id);
            return new ModelAndView("redirect:/courseTime");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }





}
