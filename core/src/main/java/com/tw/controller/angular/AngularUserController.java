package com.tw.controller.angular;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.helper.MD5EncryptionHelper;
import com.tw.service.EmployeeService;
import com.tw.service.UserService;
import com.tw.util.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by twer on 7/30/15.
 */
@Controller
@ResponseBody
@RequestMapping("/angular/user/")
public class AngularUserController {
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
    public String getUsers(HttpSession session, HttpServletResponse response) {
        List<User> users = userService.get_users();
        return gson.toJson(users);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUsers(@RequestParam int id, HttpSession session, HttpServletResponse response) {
        userService.delete_user(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertUser(@RequestParam String name, String password, int employee_id) {
        String ps = MD5EncryptionHelper.stringMD5(password);
        Employee employee = employeeService.get_element_by_id(employee_id);
        if (userService.validationCheck(employee_id)) {
            System.out.println("add successfully_____________");
            User user = new User();
            user = new User(name, ps, employee);
            userService.insert_users(user);
            return gson.toJson(user);
        } else {
            System.out.println("add failed +++++++++++++++");
            return "failed";
        }
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateUser(@RequestParam int id, String name, String password, int employee_id,
                                   HttpSession session, HttpServletResponse response) {
        System.out.println(id+name+password+employee_id+"+++++++++++");

        Employee employee = employeeService.get_element_by_id(employee_id);
            User user = new User(id, name, password, employee);
            System.out.println(id+name+password+employee_id+"+++++++++++");
            userService.update_user(user);
        }
}
