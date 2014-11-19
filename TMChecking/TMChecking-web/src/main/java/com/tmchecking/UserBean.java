/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmchecking;

//import com.team.bean.FirstLocal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {   
    boolean showIT=false;
    boolean showStudent=false;
    boolean showTeacher=false;
    
    public String checkLogin(){
        showStudent=false;
        showIT=true;
        showTeacher=true;
        return "home";
    }
    
    public String settingPage(){
        System.out.println("Setting here");
        return "setting";
    }
    public String redirectHomePage(){
        System.out.println("REDIRECT HERE");
        return "index";
    }

    public boolean isShowIT() {
        return showIT;
    }

    public void setShowIT(boolean showIT) {
        this.showIT = showIT;
    }

    

    public boolean isShowStudent() {
        return showStudent;
    }

    public void setShowStudent(boolean showStudent) {
        this.showStudent = showStudent;
    }

    public boolean isShowTeacher() {
        return showTeacher;
    }

    public void setShowTeacher(boolean showTeacher) {
        this.showTeacher = showTeacher;
    }
    
}
