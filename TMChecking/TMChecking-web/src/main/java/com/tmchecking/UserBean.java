/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmchecking;

//import com.team.bean.FirstLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    boolean showIT = false;
    boolean showStudent = false;
    boolean showTeacher = false;
    private String username;
    private String password;
    private String msg = "";

    public String checkLogin() {
        msg = "";
        if (username.equalsIgnoreCase("student") && (password.equalsIgnoreCase("student"))) {
            showStudent = true;
            showIT = false;
            showTeacher = false;
        } else if (username.equalsIgnoreCase("teacher") && (password.equalsIgnoreCase("teacher"))) {
            showStudent = false;
            showIT = false;
            showTeacher = true;
        } else if (username.equalsIgnoreCase("it") && (password.equalsIgnoreCase("it"))) {
            showStudent = true;
            showIT = true;
            showTeacher = true;
        } else {
            msg = "Invalid username and password";
            return "index";
        }
        msg = "";
        return "home";
    }

    public String settingPage() {
        return "setting";
    }

    public String redirectHomePage() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

}
