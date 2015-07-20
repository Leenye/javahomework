package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name="course_table")
public class Course {
    private  int course_id;
    private String course_name;
    private  Employee employee;
    private Set<Time> times;


    @Id
    @GeneratedValue
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }


    @Column(name="course_name")
    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "course_coach")
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany
    @JoinTable(name="course_time_table", joinColumns = {@JoinColumn(name = "relationship_course_id")},
            inverseJoinColumns = {@JoinColumn(name = "relationship_time_id")})
    public Set<Time> getTimes() {
        return times;
    }

    public void setTimes(Set<Time> times) {
        this.times = times;
    }




    public Course() {
    }


}
