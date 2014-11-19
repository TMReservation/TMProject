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
    private String msg="";

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
   
    
    public String showTeacherList(){
        System.out.println("IN TEACHER BEAN>>>");
        return "setting";
    }
    public void addTeacherInformation(){
        System.out.println("INSERT TEACHER");
        TeacherDB teacherDB=new TeacherDB();
       boolean checkSubmit= teacherDB.insertTeacher(teacher);
       if(checkSubmit)
       {
           msg="Data saved successfully";
           
           
       }
       else
       {
           msg="This entry has some error";
       }
       System.out.println(">>>>>>>>>>>>>>>");
       setTeacherInformation();
        
    }
    public void setTeacherInformation()
    {
        teacher.setFirstName("");
        teacher.setMiddleName(null);
        teacher.setLastName(null);
        teacher.setEmail(null);
        teacher.setUserName(null);
        teacher.setPassword(null);
    //    teacher.setContactNumber(Integer.parseInt(""));
        teacher.setId(null);
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
    
    
}
