package com.tw.controller;

import com.tw.entity.Usr;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by twer on 7/13/15.
 */
@RestController
@RequestMapping("/")
public class UsrController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getUsers(){
      return new  ModelAndView("index","usrs",userService.get_users());
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView insertUser(@RequestParam int id,
//                                    @RequestParam String name,
//                                    @RequestParam String gender,
//                                    @RequestParam int age,
//                                    @RequestParam String email) {
//        Usr usr = new Usr(id, name, gender, age, email);
//        System.out.println("a" + name);
//        userService.insert_users(usr);
//        return new ModelAndView("redirect:/web");
////        System.out.println("eeeeee");
////        return new ModelAndView("index", "usrs", userService.get_users());
//    }

}
