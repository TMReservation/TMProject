/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmchecking;

//import com.team.bean.FirstLocal;
import com.team.bean.FirstLocal;
import com.tm.entities.Test;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
   // @EJB
    //First first;
    @EJB
    FirstLocal firstLocal;
    List<Test> tests;
    
    public String redirectHomePage(){
        System.out.println(">>>>>>>>>");
        firstLocal.getAllProjectTest();
        System.out.println("REDIRECT HERE");
        return "index";
    }
}
