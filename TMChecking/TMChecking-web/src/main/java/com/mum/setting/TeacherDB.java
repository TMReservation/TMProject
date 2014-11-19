/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.database.connection.DatabaseSetting;
import com.tm.entities.Teacher;
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
public class TeacherDB {

    private Connection con = null;
    Statement stmt = null;
    DatabaseSetting databaseSetting = new DatabaseSetting();

    public TeacherDB() {
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

    public boolean insertTeacher(Teacher teacher) {
        try {
            System.out.println("INSERT HERE>>");
            String sql = "INSERT INTO teacher VALUES(default,'" + teacher.getFirstName() + "','" + teacher.getMiddleName() + "','" + teacher.getLastName() + "','" +teacher.getEmail()+"','"+teacher.getContactNumber()+"','"+teacher.getUserName()+"','"+teacher.getPassword()+"')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while adding value");
            return false;
        }
        return true;
    }

    public List<Teacher> getTeacherList() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher");
            System.out.println("RS >>" + rs);
            List<Teacher> teachers =new ArrayList<>();
            while (rs.next()) {
                Teacher teacher=new Teacher();                
                teacher.setFirstName(rs.getString("first_name"));
                teachers.add(teacher);
            }
            
            return teachers;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}
