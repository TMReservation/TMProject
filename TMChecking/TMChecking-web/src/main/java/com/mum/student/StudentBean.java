/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.student;

import com.mum.setting.StudentDB;
import com.tm.entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jagendra
 */
@ManagedBean(name = "studentBean")
@SessionScoped
public class StudentBean {
    
    private Student student=new Student();
    List<Student> students=new ArrayList<>();
    StudentDB studentDB=new StudentDB();
     
   

   public void addStudentInformation(){
        System.out.println("INSERT Student");
        System.out.println("SELECT VALUE "+student.getTempBatch());
        studentDB.insertStudent(student);      
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
          
    public String addStudent(){
      
        return "addStudent";
    }

    public StudentDB getStudentDB() {
        return studentDB;
    }

    public void setStudentDB(StudentDB studentDB) {
        this.studentDB = studentDB;
    }
    
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
