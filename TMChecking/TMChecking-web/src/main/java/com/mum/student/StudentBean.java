/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.student;

import com.tm.entities.Student;
import com.tm.student.StudentBeanLocal;
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
    //private ArrayList<Student> students=new ArrayList();
    
     @EJB
     StudentBeanLocal studentBeanLocal;
     List<Student> students=new ArrayList<>();
    //TeacherBeanLocal teacherBeanLocal;
   // List<Teacher> teachers=new ArrayList<>();

    public StudentBeanLocal getStudentBeanLocal() {
        return studentBeanLocal;
    }

    public void setStudentBeanLocal(StudentBeanLocal studentBeanLocal) {
        this.studentBeanLocal = studentBeanLocal;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
      
    public String addStudent(){
        
        System.out.println("First Name>>>"+ student.getFirstName());
        System.out.println("Middle Name>>>"+ student.getMiddleName());
        System.out.println("Last Name>>>"+ student.getLastName());
        System.out.println("ID >>>>>"+ student.getId());
        System.out.println("Email >>>>"+student.getEmail());
        
        students=studentBeanLocal.getStudentList();
        
        return "addStudent";
    }
    
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
