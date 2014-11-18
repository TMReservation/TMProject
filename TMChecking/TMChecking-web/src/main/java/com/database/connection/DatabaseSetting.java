/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sunil
 */
public class DatabaseSetting {
    
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "teamreservation";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "root"; 
    private String password = "root";
    
    Statement stmt = null;
    ResultSet rs = null;
    Connection conn=null;
    
    public Connection getConnection(){        
        try {
		 // Class.forName(driver).newInstance();
                  Class.forName(driver);
		  conn = DriverManager.getConnection(url+dbName,userName,password);	                 
                  conn = DriverManager.getConnection(url+dbName,userName,password);
		  stmt = conn.createStatement();
            } catch (Exception e) {
                    e.printStackTrace();
                   // return false;
         }
        return conn;
    }
    
}




