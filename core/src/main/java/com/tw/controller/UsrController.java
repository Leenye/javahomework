package com.tw.controller;

import com.tw.entity.Usr;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by twer on 7/13/15.
 */
@Controller
@RequestMapping("/")
public class UsrController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session,HttpServletResponse response) {

        Cookie cookie = new Cookie("lastVisited", "/");
        cookie.setPath("/");
        response.addCookie(cookie);

        String loginStatement = (String) session.getAttribute("loginStatement");
        if (loginStatement == "login") {
            return new ModelAndView("index", "usrs", userService.get_users());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name, String gender, int age, String email,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/");
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
            Usr usr = new Usr(name, gender, age, email);
            userService.insert_users(usr);
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "/deleteUsr/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable int id, HttpSession session,
                                    HttpServletResponse request,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/deleteUsr/"+id);
        cookie.setPath("/");
        response.addCookie(cookie);

        if (loginStatement == "login") {
            userService.delete_user(id);
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="/updateUsr/{id}",method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id,HttpSession session,HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/updateUsr/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);


        if(loginStatement == "login"){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("update");
            Usr targetUsr = userService.get_element_by_id(id);
            modelAndView.addObject("usr", targetUsr);
            return modelAndView;
        }else{
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value="/updateUsr/{id}",method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, String gender, int age, String email,
                                   HttpSession session,HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/updateUsr/" +id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if(loginStatement == "login"){
            Usr usr = new Usr(id,name,gender,age,email);
            userService.update_user(usr);
            return new ModelAndView("redirect:/");
        }else{
            return new ModelAndView("redirect:/login");
        }
    }
}
