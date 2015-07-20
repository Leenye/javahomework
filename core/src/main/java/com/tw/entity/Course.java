package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name="course_table")
public class Course {
    private  int id;
    private String name;
    private String time;
    private  Employee employee;

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

    @Column(name="time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "coach_id")
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Course(){

    }

    public Course(String name, String time, Employee employee) {
        this.name = name;
        this.time = time;
        this.employee = employee;
    }

    public Course(int id, String time, String name, Employee employee) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.employee = employee;
    }

    //
//    @ManyToMany
//    @JoinTable(name="course_time_table", joinColumns = {@JoinColumn(name = "relationship_course_id")},
//            inverseJoinColumns = {@JoinColumn(name = "relationship_time_id")})
//    public Set<Time> getTimes() {
//        return times;
//    }
//
//    public void setTimes(Set<Time> times) {
//        this.times = times;
//    }


}
