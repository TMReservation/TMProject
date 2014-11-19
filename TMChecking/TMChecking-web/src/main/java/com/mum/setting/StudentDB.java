/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.database.connection.DatabaseSetting;
import com.tm.entities.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sunil
 */
public class StudentDB {

    private Connection con = null;
    Statement stmt = null;
    DatabaseSetting databaseSetting = new DatabaseSetting();

    public StudentDB() {
        getConfigConnection();
    }

    public Connection getConfigConnection() {
        try {
            con = databaseSetting.getConnection();
            stmt = con.createStatement();
            return con;
        } catch (SQLException ex) {
            System.out.println("Connection erro");
        }
        return con;
    }

    public boolean insertStudent(Student student) {
        try {
            
            System.out.println("studetn name"+student.getFirstName() + student.getLastName());
            String sql = "INSERT INTO student VALUES(default,'" + student.getFirstName() + "','" + student.getMiddleName()+ "','" + student.getLastName()+ "','"+ student.getEmail() +"','" +0+"','" + student.getProgram() +"','" + student.getContactnumber() + "','" + student.getUsername() + "','" + student.getPassword() + "','" + student.getBatch() + "')";
            
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while adding value");
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");
            System.out.println("RS >>" + rs);
            List<Student> students =new ArrayList<>();
            while (rs.next()) {
                String lastName = rs.getString("first_name");
                students.add(new Student(rs));
                System.out.println(lastName + "\n");
            }
            
            return students;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}