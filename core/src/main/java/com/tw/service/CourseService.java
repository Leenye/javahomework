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
        return courseDao.get_courses();
    }

    public void insert_course(Course course){
        courseDao.insert_course(course);
    }

    public void delete_course(int id){
        courseDao.delete_course(id);
    }

    public Course get_element_by_id(int id){
      return   courseDao.get_element_by_id(id);
    }

    public void update_course(Course course){
        courseDao.update(course);
    }



}
