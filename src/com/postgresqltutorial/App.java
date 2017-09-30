/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postgresqltutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App{
 
    private static String url = "jdbc:postgresql://localhost:5432/Chan";
    private static String user = "Chan";
    private static String password = "";
 
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String filepath = "/Users/Chan/NetBeansProjects/PostgreSQLJDBC/src/com/postgresqltutorial/grades.txt";
        Scanner scan = new Scanner(new File(filepath));
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            String sql = "update histogram set number=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            while(scan.hasNext()) {
            String num = scan.nextLine();
            preparedStatement.setString(1,num);
        }
            
            ResultSet result = preparedStatement.executeQuery();
        
        while (result.next()) {
            String names = result.getString("number"); 
            System.out.println(names);
        }
        
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
}

