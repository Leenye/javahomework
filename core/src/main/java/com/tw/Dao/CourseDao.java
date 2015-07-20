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
        System.out.println("+++++++++++++++++++");
        Course course3 = (Course) session.load(Course.class, 3);
        System.out.println(course3.getCourse_name()+ "------------");

        System.out.println(course3.getEmployee().getEmployee_id()+ "------------");


        String hql = "from Course";
        Query query  = session.createQuery(hql);

        List<Course> courses = query.list();
        session.getTransaction().commit();
        return courses;
    }


}
