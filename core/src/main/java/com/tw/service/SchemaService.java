package com.tw.service;

import com.tw.dao.SchemaDao;
import com.tw.dao.EmployeeDao;

import com.tw.entity.Employee;
import com.tw.entity.Schema;
import com.tw.entity.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by twer on 7/23/15.
 */
@Service
public class SchemaService {

    @Autowired
    SchemaDao schemaDao;
    @Autowired
    EmployeeDao employeeDao;

    public List<Schema> get_schemas() {
        return schemaDao.get_schemas();
    }

    public void insert_schema(Schema schema){
        schemaDao.insert_schema(schema);
    }

    public void delete_schema(int id){
        schemaDao.delete_schema(id);
    }

    public Schema get_element_by_id(int id){
        return   schemaDao.get_element_by_id(id);
    }

    public void update_schema(Schema schema){
        schemaDao.update(schema);
    }

    public boolean validationCheck(int coach_id,String time){
        Employee employee = employeeDao.get_element_by_id(coach_id);
        boolean flag = false;
        if ( employee != null ){

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Schema.class);
            criteria.add(Restrictions.eq("employee", employee));
            criteria.add(Restrictions.eq("time", time));
            List<Employee> list = criteria.list();
            session.getTransaction().commit();
            if(list.size()==0){
                flag = true;
            }
        }
        return flag;
    }

}
