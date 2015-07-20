package com.tw.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by twer on 7/8/15.
 */
@Entity
@Table(name="usr_table")
public class Usr {
    private  int id;
    private String name;
    private  String gender;
    private  int age;
    private  String email;
    private  String password;
    private Employee employee;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }




    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="age")
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    @Column(name="gender")
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    @Column(name="password")
    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public Usr() {
    }

    public Usr(String name, String gender, int age, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public Usr(String name, String gender, int age, String email, String password ,Employee employee) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        this.employee = employee;

    }


    public Usr(int id, String name, String gender, int age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public Usr(int id, String name, String gender, int age, String email, String password ,Employee employee) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        this.employee = employee;


    }
}
