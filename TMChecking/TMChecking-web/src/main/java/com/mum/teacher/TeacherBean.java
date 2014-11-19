/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.teacher;

import com.mum.setting.TeacherDB;
import com.tm.entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "teacherBean")
@SessionScoped
public class TeacherBean {
    List<Teacher> teachers=new ArrayList<>();
    Teacher teacher=new Teacher();
    TeacherDB teacherDB=new TeacherDB();
   
    
    public String showTeacherList(){
        System.out.println("IN TEACHER BEAN>>>");
        return "setting";
    }
    public void addTeacherInformation(){
        System.out.println("INSERT TEACHER");
        TeacherDB teacherDB=new TeacherDB();
       boolean checkSubmit= teacherDB.insertTeacher(teacher);  
        
    }
    
    
    
    public String addTeacher()
    {         
        teachers=new ArrayList<>();
        teachers=teacherDB.getTeacherList();
        for(Teacher t:teachers){
            System.out.println("T is "+t.getFirstName());
        }
        System.out.println("SIZE IS "+teachers.size());
        return "addTeacher";
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    
   
    
//    public String showTeacherList(){
//        System.out.println("IN TEACHER BEAN>>>");
//        return "setting";
//    }
//    public void addTeacherInformation(){
//        System.out.println("INSERT TEACHER");
//        TeacherDB teacherDB=new TeacherDB();
//        teacherDB.insertTeacher(teacher);      
//    }
//    public String addTeacher()
//    {         
//        teachers=new ArrayList<>();
//        
//        teachers=teacherDB.getTeacherList();       
//        return "addTeacher";
//    }
//
//    public List<Teacher> getTeachers() {
//        return teachers;
//    }

//    public void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//    
    
}
