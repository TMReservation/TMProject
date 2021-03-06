/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.database.connection.DatabaseSetting;
import com.tm.entities.Student;
import com.tm.entities.TMChecking;
import com.tm.entities.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        System.out.println("TEACHER IS " + teacher.getUserName());
        try {
            String sql = "INSERT INTO teacher VALUES(default,'" + teacher.getFirstName1() + "','" + teacher.getMiddleName() + "','" + teacher.getLastName() + "','" + teacher.getEmailID() + "','" + teacher.getContact() + "','" + teacher.getUsernameTeacher() + "','" + teacher.getPasswordTeacher() + "',0)";
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher order by id desc");
            List<Teacher> teachers = new ArrayList<>();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setMiddleName(rs.getString("middle_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setEmail(rs.getString("email"));
                teacher.setContactNumber(rs.getInt("contact_number"));
                teacher.setUserName(rs.getString("user_name"));
                teacher.setPassword(rs.getString("password"));
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

    public boolean saveTMChecking(Date currentDate, String selectTeacherId, int studentId, int enabledTM, int pending) {
        try {
            System.out.println("INSERT TM>>");
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = formatter.format(currentDate);
            System.out.println("DATE IS " + s);
            String sql = "INSERT INTO teamchecking VALUES(default,'" + s + "','" + selectTeacherId + "','" + studentId + "','" + enabledTM + "','" + pending + "')";
            System.out.println("AFTER SQL");
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while adding value");
            return false;
        }
        return true;

    }

    public List<TMChecking> getTMCheckingList(int id) {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teamchecking where student_id='" + id + "' order by id desc");
            List<TMChecking> tMCheckings = new ArrayList<>();
            while (rs.next()) {
                System.out.println("NAME IS " + rs.getInt("teacher_id"));
                TMChecking tMChecking = new TMChecking();
                Teacher t = findByTeacherId(rs.getInt("teacher_id"));
                tMChecking.setId(rs.getInt("id"));
                tMChecking.setChecked(rs.getInt("checked"));
                tMChecking.setPending(rs.getInt("pending"));
                tMChecking.setCheckTime(rs.getString("checking_time"));
                tMChecking.setTeacherId(t.getFirstName() + t.getLastName());
                tMCheckings.add(tMChecking);
            }
            return tMCheckings;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public Teacher findByTeacherId(int id) {
        Teacher teacher = new Teacher();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teacher where id='" + id + "'");
            while (rs.next()) {
                System.out.println(" NAME IS: " + rs.getString("first_name") + "lastName " + rs.getString("last_name"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return teacher;

    }

    public List<TMChecking> getTMCheckingStudentList(int id) {
         List<TMChecking> tMCheckings = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teamchecking where teacher_id='" + id + "' order by id desc");           
            while (rs.next()) {
                System.out.println("NAME IS " + rs.getInt("id"));
                TMChecking tMChecking = new TMChecking();
                Student s = findByStudentId(rs.getInt("student_id"));
                tMChecking.setId(rs.getInt("id"));
                tMChecking.setChecked(rs.getInt("checked"));
                tMChecking.setPending(rs.getInt("pending"));
                tMChecking.setCheckTime(rs.getString("checking_time"));
                tMChecking.setStudentId(s.getFirstName() + s.getLastName());
                tMCheckings.add(tMChecking);
            }
           
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
        }
         return tMCheckings;
    }   

    public Student findByStudentId(int id) {
        Student student = new Student();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where id='" + id + "'");
            while (rs.next()) {
                System.out.println(" NAME IS: " + rs.getString("first_name") + "lastName " + rs.getString("last_name"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return student;

    }
}
