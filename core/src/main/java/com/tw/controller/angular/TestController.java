package com.tw.controller.angular;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by twer on 7/30/15.
 */
@Controller
@ResponseBody
@RequestMapping("/angular/test")
public class TestController {

    @RequestMapping(method = RequestMethod.POST)
    public void insertUser(@RequestParam String he) {
        System.out.println("进入test+++++++++++++");
    }
}
