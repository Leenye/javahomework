package com.tw.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.service.EmployeeService;
import com.tw.service.UserService;
import com.tw.util.HibernateProxyTypeAdapter;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by twer on 7/13/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    private Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
        public String getUsers(HttpSession session, HttpServletResponse response) {
//        Cookie cookie = new Cookie("lastVisited", "/user");
//        cookie.setPath("/");
//        response.addCookie(cookie);
//        String loginStatement = (String) session.getAttribute("loginStatement");
        List<User> users = userService.get_users();
        return gson.toJson(users);
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUsers( @RequestParam int id, HttpSession session, HttpServletResponse response) {
//        Cookie cookie = new Cookie("lastVisited", "user/deleteUser/" + id);
//        cookie.setPath("/");
//        response.addCookie(cookie);
        userService.delete_user(id);

    }

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam String name, String password, int employee_id,
                                   HttpSession sessionHttp, HttpServletResponse response) {
        String loginStatement = (String) sessionHttp.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "/user");
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            String ps = MD5EncryptionHelper.stringMD5(password);
            Employee employee = employeeService.get_element_by_id(employee_id);

            if (userService.validationCheck(employee_id)) {
                User user = new User(name, ps, employee);
                userService.insert_users(user);
                return new ModelAndView("redirect:/user");

            } else {
                return new ModelAndView("redirect:/user");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }



    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.GET)
    public ModelAndView getElementById(@PathVariable int id, HttpSession session, HttpServletResponse response) {

        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUser/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("userUpdate");
            User targetUser = userService.get_element_by_id(id);
            modelAndView.addObject("user", targetUser);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable int id, String name, String password, int employee_id,
                                   HttpSession session, HttpServletResponse response) {
        String loginStatement = (String) session.getAttribute("loginStatement");
        Cookie cookie = new Cookie("lastVisited", "user/updateUser/" + id);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (loginStatement == "login") {
            if (userService.validationCheck(employee_id)) {
                Employee emp = employeeService.get_element_by_id(employee_id);
                User user = new User(id, name, password, emp);
                userService.update_user(user);
                return new ModelAndView("redirect:/user");
            } else {
                return new ModelAndView("redirect:/user");
            }

        } else {
            return new ModelAndView("redirect:/login");
        }
    }
}
