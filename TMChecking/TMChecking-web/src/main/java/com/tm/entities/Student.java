/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.entities;

import java.sql.ResultSet;

/**
 *
 * @author sunil
 */

public class Student  {   
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Integer isDelete;
    private String program;
    private int contactnumber;
    private String username;
    private String password;
    private String batch;
    ResultSet rs;
    private String tempBatch;
    private String tempProgram;
    private String fullName;
    
    public Student() {
    }
    public Student(Integer id) {
        this.id = id;
    }

    public Student(ResultSet rs) {
        this.rs=rs;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

   

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getFullName() {
        return getFirstName()+getMiddleName()+getLastName();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tm.entities.Student[ id=" + id + " ]";
    }

    public String getTempBatch() {
        return tempBatch;
    }

    public void setTempBatch(String tempBatch) {
        this.tempBatch = tempBatch;
    }

    public String getTempProgram() {
        return tempProgram;
    }

    public void setTempProgram(String tempProgram) {
        this.tempProgram = tempProgram;
    }
            
}
