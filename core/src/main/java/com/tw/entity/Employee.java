package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by twer on 7/19/15.
 */
@Entity
@Table(name="employee")
public class Employee {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String email;
    private String role;
    private String statement;

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

    @Column(name="gender")

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="age")

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Column(name="email")

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="statement")
    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Employee(){

    }

    public Employee(String name, String role, String statement) {
        this.name = name;
        this.role = role;
        this.statement = statement;
    }

    public Employee(int id, String name,  String role,String statement) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.statement = statement;

    }

    public Employee(String name, String gender, int age, String email, String role, String statement) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.role = role;
        this.statement = statement;
    }

    public Employee(int id, String name, String gender, int age, String email, String role, String statement) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.role = role;
        this.statement = statement;
    }
}
