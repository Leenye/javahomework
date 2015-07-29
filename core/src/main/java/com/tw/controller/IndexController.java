package com.tw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by twer on 7/21/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getIndex(HttpSession session,HttpServletResponse response) {
        Cookie cookie = new Cookie("lastVisited", "/");
        cookie.setPath("/");
        response.addCookie(cookie);
            ModelAndView modelAndView = new ModelAndView();
        response.setContentType("text/html;charset=utf-8");
            modelAndView.setViewName("index");
            return modelAndView;
    }

}
