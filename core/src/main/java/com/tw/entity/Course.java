package com.tw.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name="course_table")
public class Course {
    private  int course_id;
    private String course_name;
    private  Usr usr;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_coach")
    public Usr getCourse_coach(){
        return usr;
    }
    public void setCourse_coach(Usr usr) {
        this.usr = usr;
    }



    public Course() {
    }

//    public Course(int course_id,String course_name,int course_coach) {
//        this.course_id = course_id;
//        this.course_name = course_name;
//    }


}
