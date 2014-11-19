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
    private String msg="";
   

   public void addStudentInformation(){
        System.out.println("INSERT Student");
        System.out.println("SELECT VALUE "+student.getTempBatch());
        boolean check = studentDB.insertStudent(student);   
        
        if(check){
            clear();
            System.out.println(msg);
            msg="Student Added sucessfully";
        }else{
            msg="Problem in Insertion";
              System.out.println(msg);
        }
    }
   
   public void clear(){
       student.setBatch("");
       student.setContactnumber(0);
       student.setEmail("");
       student.setFirstName("");
       student.setMiddleName("");
       student.setLastName("");
       student.setUsername("");
       student.setId(null);       
   }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
          
    public String addStudent(){
        msg="";
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
