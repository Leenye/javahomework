package com.tw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.tw.service.UserService;

import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by twer on 7/13/15.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session) {
        session.invalidate();
        return new ModelAndView("login");
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ModelAndView loginJudgement(@CookieValue(value = "lastVisited", defaultValue = "") String previousUrl,
                                       @RequestParam String name, String password,HttpSession session) throws UnsupportedEncodingException {

        boolean logined = userService.login_judgement(name, password);
//        System.out.println(previousUrl);

        if (logined==true) {
            session.setAttribute("loginStatement","login");
            return new ModelAndView("redirect:"+ previousUrl);
        }else {
             System.out.println("请输入正确的用户名和密码");
            return new ModelAndView("redirect:/login");
        }
    }

}
