package com.tw.dao;

import com.tw.entity.Schema;
import com.tw.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by twer on 7/23/15.
 */
@Repository
public class SchemaDao {

    public List<Schema> get_schemas() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from Schema";
        Query query  = session.createQuery(hql);

        List<Schema> schemas = query.list();
        session.getTransaction().commit();
        return schemas;
    }

    public void insert_schema(Schema schema) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();//开启操作数据库的事务
        session.save(schema);
        session.getTransaction().commit();
    }

    public void delete_schema(int id) {
        Schema schema = new Schema();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        schema.setId(id);
        session.delete(schema);
        session.getTransaction().commit();
    }

    public Schema get_element_by_id(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Schema schema = (Schema) session.get(Schema.class, id);
        session.getTransaction().commit();
        return schema;
    }

    public void update(Schema schema) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(schema);
        session.getTransaction().commit();
    }


}
