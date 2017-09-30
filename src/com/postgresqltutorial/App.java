/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postgresqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App{
 
    private static String url = "jdbc:postgresql://localhost:5432/Chan";
    private static String user = "Chan";
    private static String password = "";
 
    public static void main(String[] args) throws SQLException {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        
        
        Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM people");
        ResultSet result = preparedStatement.executeQuery();
        //ResultSet result = statement.executeQuery("SELECT * FROM people");
        
        while (result.next()) {
            String names = result.getString("name"); 
            System.out.println(names);
        }
        
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
}

