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
 
    private static String url = "jdbc:postgresql://localhost:5432/Mahad";
    private static String user = "Mahad";
    private static String password = "";
 
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String filepath = "/Users/Mahad/IdeaProjects/JavaJDBC/src/com/postgresqltutorial/grades.txt";
        Scanner scan = new Scanner(new File(filepath));
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            
            String sql = "INSERT into histogram (id, number) VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            int index = 1;
            while(scan.hasNext()) {
                int num = scan.nextInt();
                preparedStatement.setInt(1, index);
                preparedStatement.setInt(2,num);
                preparedStatement.executeUpdate();

                index++;
            }
                        
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}

