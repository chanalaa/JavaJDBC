/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postgresqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App{
 
    private static String url = "jdbc:postgresql://localhost:5432/Chan";
    private static String user = "Chan";
    private static String password = "";
 
 
    public static void main(String[] args) throws SQLException {
        
        App app = new App();
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
}

