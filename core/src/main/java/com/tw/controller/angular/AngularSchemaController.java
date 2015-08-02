package com.tw.controller.angular;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.entity.Coach;
import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.Schema;
import com.tw.service.CoachService;
import com.tw.service.CourseService;
import com.tw.service.EmployeeService;
import com.tw.service.SchemaService;
import com.tw.util.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by twer on 8/2/15.
 */
@Controller
@ResponseBody
@RequestMapping("/angular/schema/")

public class AngularSchemaController {
    @Autowired
    CourseService courseService;
    @Autowired
    CoachService coachService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SchemaService schemaService;

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
    public String getSchemas() {
        List<Schema> schemas = schemaService.get_schemas();
        return gson.toJson(schemas);
    }

    @RequestMapping(value = "/course/",method = RequestMethod.GET)
    public String getCourses() {
        List<Course> courses = courseService.get_courses();
        return gson.toJson(courses);
    }

    @RequestMapping(value = "/coach/",method = RequestMethod.GET)
    public String getEmployees() {
        List<Coach> coaches = coachService.get_coaches();
        return gson.toJson(coaches);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSchema(@RequestParam int id){
        schemaService.delete_schema(id);
    }

}
