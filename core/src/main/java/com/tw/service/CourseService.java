package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

    public boolean validationCheck(String name){
        boolean flag = false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Course.class);
        criteria.add(Restrictions.eq("name", name));
        List<Employee> list = criteria.list();
        session.getTransaction().commit();
        if (list.size() == 0) {
            flag = true;
        }
        return flag;
    }
}
