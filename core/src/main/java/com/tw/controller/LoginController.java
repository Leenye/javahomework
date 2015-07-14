package com.tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tw.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;

/**
 * Created by twer on 7/13/15.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUsers() {
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginJudgement(@RequestParam String name, String password) {
        System.out.println(name+password);
        boolean loginAble = userService.login_judgement(name,password);
        if (loginAble==true) {
            return new ModelAndView("redirect:/");
        }else {
             System.out.println("请输入正确的用户名和密码");
            return new ModelAndView("redirect:/login");
        }
    }

}
