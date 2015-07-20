package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by twer on 7/17/15.
 */
@Entity
@Table(name="time_table")
public class Time {
    private  int time_id;
    private String course_time;
    private Set<Course> courses;

    @Id
    @GeneratedValue
    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    @Column(name="course_time")
    public String getCourse_time() {
        return course_time;
    }
    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }


    @ManyToMany(mappedBy = "times")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    public Time() {
    }

    public Time(String course_time){
        this.course_time = course_time;
    }

    public Time(int time_id,String course_time) {
        this.time_id = time_id;
        this.course_time = course_time;
    }


}
