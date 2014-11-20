/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.entities;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 *
 * @author sunil
 */

public class Teacher implements Serializable {
   
    private Integer id;    
    private String firstName;  
    private String middleName;
    private String lastName;
    private String email;
    private int contactNumber;
    private String userName;
    private String password;
    private String fullName;
    private String firstName1;
    private String emailID;
    private int contact;
    private String usernameTeacher;
    private String passwordTeacher;

    public String getUsernameTeacher() {
        return usernameTeacher;
    }

    public void setUsernameTeacher(String usernameTeacher) {
        this.usernameTeacher = usernameTeacher;
    }

    public String getPasswordTeacher() {
        return passwordTeacher;
    }

    public void setPasswordTeacher(String passwordTeacher) {
        this.passwordTeacher = passwordTeacher;
    }
    
    
    
    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
            
    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }
    

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }
    
  
    

    public String getFullName() {
        return "getFirstName()+getMiddleName()+getLastName()";
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.entities.Teacher[ id=" + id + " ]";
    }
    
}
