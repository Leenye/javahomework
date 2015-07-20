package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/19/15.
 */
@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> get_courses() {

        System.out.println(courseDao.get_courses());

        return courseDao.get_courses();
    }

}
