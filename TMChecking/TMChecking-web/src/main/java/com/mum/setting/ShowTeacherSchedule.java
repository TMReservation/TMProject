/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.tm.entities.TMChecking;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
@ManagedBean
@SessionScoped
public class ShowTeacherSchedule implements Serializable{
    List<TMChecking> checkingList=new ArrayList<>();
    TeacherDB teacherDB=new TeacherDB();
    
    
    public String addAppointmentStudent() {      
        checkingList=new ArrayList<>();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int teacherId = (int) session.getAttribute("userId");
        checkingList = teacherDB.getTMCheckingStudentList(teacherId);
        System.out.println("TM CHECKNING LIST SIZE " + checkingList.size());

        return "setDateTimeTeacher";
    }

    public List<TMChecking> getCheckingList() {
        return checkingList;
    }

    public void setCheckingList(List<TMChecking> checkingList) {
        this.checkingList = checkingList;
    }

  
}
