package com.tw.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/23/15.
 */
@Entity
@Table(name = "schedule")
public class Schema {
    private int id;
    private Course course;
    private Employee employee;
    private String time;
    private String customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Column(name = "customer")
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public Schema(){

    }

    public Schema(Course course, Employee employee, String time, String customer) {
        this.course = course;
        this.employee = employee;
        this.customer = customer;
        this.time = time;
    }

    public Schema(int id, Course course, Employee employee, String time, String customer) {
        this.id = id;
        this.course = course;
        this.employee = employee;
        this.time = time;
        this.customer = customer;
    }
}
