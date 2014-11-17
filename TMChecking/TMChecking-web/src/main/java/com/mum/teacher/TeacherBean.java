/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.teacher;

import com.tm.entities.Teacher;
import com.tm.teacher.TeacherBeanLocal;
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
    @EJB
    TeacherBeanLocal teacherBeanLocal;
    List<Teacher> teachers=new ArrayList<>();
    Teacher teacher=new Teacher();
    
   
    
    public String showTeacherList(){
        System.out.println("IN TEACHER BEAN");
        teachers=teacherBeanLocal.getTeacherList();
        System.out.println("Teacher size is ");
        return "setting";
    }
    public String addTeacherInformation(){
        System.out.println("Add teacher here");
        System.out.println("Teacher name "+teacher.getFirstName());
        //firstLocal.addTeacherInfo(teacher);
        System.out.println("END");
        return "addTeacher";
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    
}
