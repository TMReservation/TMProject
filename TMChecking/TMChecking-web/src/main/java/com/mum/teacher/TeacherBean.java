/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.teacher;

import com.mum.setting.TeacherDB;
import com.tm.entities.Teacher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author sunil
 */
@ManagedBean(name ="teacherBean")
@SessionScoped
public class TeacherBean implements Serializable{

    List<Teacher> teachers = new ArrayList<>();
    Teacher teacher = new Teacher();
    private int currentTeacherIndex;
    TeacherDB teacherDB = new TeacherDB();
    private String msg = "";
    private ArrayList<SelectItem> selectTeacherList;
    private int teacherSelectId;

    public int getCurrentTeacherIndex() {
        return currentTeacherIndex;
    }

    public void setCurrentTeacherIndex(int currentTeacherIndex) {
        this.currentTeacherIndex = currentTeacherIndex;
    }

    public String checkUpdateSetting() {
        System.out.println("Inside update " + teacher.getId());

        return "";
    }

    public TeacherDB getTeacherDB() {
        return teacherDB;
    }

    public void setTeacherDB(TeacherDB teacherDB) {
        this.teacherDB = teacherDB;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String showTeacherList() {
        System.out.println("IN TEACHER BEAN>>>");
        return "setting";
    }

    public void addTeacherInformation() { 
        System.out.println("TEACHER NAME "+teacher.getFirstName1());
        System.out.println("First Name is "+teacher.getEmail());
        boolean checkSubmit = teacherDB.insertTeacher(teacher);
        if (checkSubmit) {
            msg = "Data saved successfully";
            teachers = new ArrayList<>();
            teachers = teacherDB.getTeacherList();

        } else {
            msg = "This entry has some error";
        }

        setTeacherInformation();

    }

    public void setTeacherInformation() {
        teacher.setFirstName("");
        teacher.setMiddleName(null);
        teacher.setLastName(null);
        teacher.setEmail(null);
        teacher.setUserName(null);
        teacher.setPassword(null);
    }

    public String addTeacher() {
        teachers = new ArrayList<>();
        teachers = teacherDB.getTeacherList();
        teacher=new Teacher();
        msg = "";
        return "addTeacher";
    }

    public void teacherTest() {
        System.out.println("ID IS " + teacherSelectId);
    }

    public void updateTeacher() {
        System.out.println("Teacher object " + teacher.getFirstName());
    }

    public String addFreeTime() {
        System.out.println("IMMEDIATE TRUE");
        return "setDateTimeTeacher";
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

    public ArrayList<SelectItem> getSelectTeacherList() {
        return selectTeacherList;
    }

    public void setSelectTeacherList(ArrayList<SelectItem> selectTeacherList) {
        this.selectTeacherList = selectTeacherList;
    }

    public int getTeacherSelectId() {
        return teacherSelectId;
    }

    public void setTeacherSelectId(int teacherSelectId) {
        this.teacherSelectId = teacherSelectId;
    }

}
