package com.tw.dao;

import com.tw.entity.Usr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 7/8/15.
 */
public class UsrDao {

    public Connection connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_usr_info", "root", "");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    Statement statement;

    public List<Usr> get_usrs() {
        List<Usr> usrs = new ArrayList<Usr>();
        try {
            statement = connection().createStatement();
            ResultSet rs = statement.executeQuery("select * from usr_table");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                Usr usr = new Usr(id, name, gender, age, email);
                usrs.add(usr);
            }
            return usrs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public int insert_usr(Usr usr){
        int result = 0;
        try {
            statement = connection().createStatement();
            String sql = "insert into usr_table values(null,'"+usr.getName()+"','"+usr.getGender()+"','"+usr.getAge()+"','"+usr.getEmail()+"')";
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    public int delete_usr(int id){
        int result = 0;
        try {
            statement = connection().createStatement();
            String sql = "delete from usr_table where id="+id;
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public Usr get_element_by_id(int id) {
        Usr usr = null;
        try {
            statement = connection().createStatement();
            ResultSet rs = statement.executeQuery("select * from usr_table where id='"+ id +"'");
            rs.next();

            usr = new Usr(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getInt("age"),
                    rs.getString("email")
            );

            rs.close();
            statement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return usr;

    }

    public int update(Usr usr){
        int result = 0;
        try {
            statement = connection().createStatement();
            String sql = "update usr_table set name = '"+usr.getName()+"', gender = '"+usr.getGender()
                    +"',age = "+usr.getAge()+" ,email = '"+usr.getEmail()
                    +"' where id = "+usr.getId()+"";
            result = statement.executeUpdate(sql);
            statement.close();

//            ResultSet rs = statement.executeQuery("UPDATE usr_table SET name='"+usr.getName()+"',gender='"+usr.getGender()+"',age="+usr.getAge()+",email='"+usr.getEmail()+"' where id='"+ usr.getId()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


//    public List<Usr> update_usr(){
//        List<Usr> usrs = new ArrayList<Usr>();
//
//
//    }



}
