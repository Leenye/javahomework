package com.tw.dao;

import com.tw.entity.Course;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/18/15.
 */
@Repository
public class CourseDao {

    public List<Course> get_courses() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Course";
        Query query  = session.createQuery(hql);

        List<Course> courses = query.list();
        session.getTransaction().commit();
        return courses;
    }

    public void insert_course(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(course);
        session.getTransaction().commit();
    }

    public void delete_course(int id) {
        Course course = new Course();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        course.setId(id);
        session.delete(course);
        session.getTransaction().commit();
    }

    public Course get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Course course = (Course) session.get(Course.class, id);
        session.getTransaction().commit();
        return course;
    }

    public void update(Course course) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
    }




}
