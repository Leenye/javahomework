package com.tw.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by twer on 7/8/15.
 */
@Entity
@Table(name="user")
public class User {
    private  int id;
    private String name;
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


    @Column(name="password")
    public String getPassword() {return password;}
    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password, Employee employee) {
        this.name = name;
        this.password = password;
        this.employee = employee;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, String password, Employee employee) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.employee = employee;
    }
}
