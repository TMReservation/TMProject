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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

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
    private int currentStudentIndex;
    private ArrayList<SelectItem> selectProgram;
    private ArrayList<SelectItem> selectBatch;

    

    public int getCurrentStudentIndex() {
        return currentStudentIndex;
    }

    public void setCurrentStudentIndex(int currentStudentIndex) {
        this.currentStudentIndex = currentStudentIndex;
    }
   

    
    public void addStudentInformation() {
        System.out.println("INSERT Student");
        System.out.println("SELECT VALUE " + student.getTempBatch());
        boolean check = studentDB.insertStudent(student);

        if (check) {
            clear();
            System.out.println(msg);
            msg = "Student Added sucessfully";
        } else {
            msg = "Problem in Insertion";
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
       //student.setId(null);       
   }

   
    public String initiateProgram() {

        List<String> programs = new ArrayList<String>();
        programs.add("Compro Master");
        programs.add("Compro Bachelor");
        programs.add("Accounting");
        programs.add("MBA");

        SelectItem programItem = new SelectItem();
        selectProgram = new ArrayList<SelectItem>();
        for (int i = 0; i < programs.size(); i++) {
            programItem = new SelectItem(i, programs.get(i));
         
            selectProgram.add(programItem);
        }
           System.out.println("Select programe "+selectProgram.size());
	
        return "";
    }
    
     public String listBatch() {

        List<String> batchs = new ArrayList<String>();
        batchs.add("Feb 2014");
        batchs.add("June 2014");
        batchs.add("Aug 2014");
        batchs.add("Oct 2014");
        batchs.add("Feb 2015");
        batchs.add("June 2015");

        SelectItem batchItem = new SelectItem();
        selectBatch = new ArrayList<SelectItem>();
        for (int i = 0; i < batchs.size(); i++) {
            batchItem = new SelectItem(i, batchs.get(i));
         
            selectBatch.add(batchItem);
        }
           	
        return "";
    }

    
     
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
          
    public String addStudent(){
        msg="";
        students=studentDB.getStudentList();
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

    public ArrayList<SelectItem> getSelectProgram() {
        return selectProgram;
    }

    public ArrayList<SelectItem> getSelectBatch() {
        return selectBatch;
    }
    
 
    public String checkUpdateSetting(){
        System.out.println("Inside update "+student.getId());
        
        return "";
    }
}
