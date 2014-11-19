/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.database.connection.DatabaseSetting;
import com.tm.entities.Setting;
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
public class SettingDB {

    private Connection con = null;
    Statement stmt = null;
    DatabaseSetting databaseSetting = new DatabaseSetting();

    public SettingDB() {
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

    public List<Setting> getSettingList() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM setting order by id desc");
            System.out.println("RS >>" + rs);
            List<Setting> settings = new ArrayList<>();
            while (rs.next()) {
                Setting setting = new Setting();
                setting.setId(rs.getInt("id"));
                setting.setRole(rs.getString("role"));
                Teacher t=findByTeacherId(rs.getInt("teacher_id"));
                setting.setTeacherId(rs.getInt("teacher_id"));
                setting.setTempFullName(t.getFirstName()+t.getLastName());
                settings.add(setting);
            }
            return settings;
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

}
