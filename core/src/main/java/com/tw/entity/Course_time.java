//package com.tw.entity;
//
//import javax.persistence.*;
//
///**
// * Created by twer on 7/17/15.
// */
//@Entity
//@Table(name="course_time_table")
//public class Course_time {
//    private  int relationship_id;
//    private  int relationship_course_id;
//    private  int relationship_time_id;
//    private  int coach_id;
//
//
//
//    @Id
//    @GeneratedValue
//    public int getRelationship_id() {
//        return relationship_id;
//    }
//    public void setRelationship_id(int relationship_id) {
//        this.relationship_id = relationship_id;
//    }
//
//    @Column(name="relationship_course_id")
//    public int getRelationship_course_id(){
//        return relationship_course_id;
//    }
//    public void setRelationship_course_id(int relationship_course_id) {
//        this.relationship_course_id = relationship_course_id;
//    }
//
//    @Column(name="relationship_time_id")
//    public int getRelationship_time_id() {
//        return relationship_time_id;
//    }
//    public void setRelationship_time_id(int relationship_time_id) {
//        this.relationship_time_id = relationship_time_id;
//    }
//
//    @Column(name="coach_id")
//    public int getCoach_id() {
//        return coach_id;
//    }
//    public void setCoach_id(int coach_id) {
//        this.coach_id = coach_id;
//    }
//
//    public Course_time(){
//
//    }
//
//    public Course_time(int relationship_id, int relationship_course_id, int relationship_time_id, int coach_id) {
//        this.relationship_id = relationship_id;
//        this.relationship_course_id = relationship_course_id;
//        this.relationship_time_id = relationship_time_id;
//        this.coach_id = coach_id;
//    }
//}
