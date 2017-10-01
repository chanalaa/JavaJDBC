/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postgresqltutorial;

import static com.postgresqltutorial.App.connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;


public class App{
 
    private static String url = "jdbc:postgresql://localhost:5432/Chan";
    private static String user = "Chan";
    private static String password = "";
 
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String filepath = "/Users/Chan/NetBeansProjects/PostgreSQLJDBC/src/com/postgresqltutorial/grades.txt";
        Scanner scan = new Scanner(new File(filepath));
            try {
                connection();
                useStatementMethodtoInsertIntoDatabase();
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static Connection connection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    
    public static void createTableFromDatabase(){} // leave this one till last
    public static void readFromDatabase(){    }
    public static void useStatementMethodtoInsertIntoDatabase() throws SQLException{
        Statement statement = connection().createStatement();
        statement.executeUpdate("INSERT into histogram (id, number) values (101, 88)" );
       
    }
    public static void useStatementMethodtoDeletefromDatabase(){}
    public static void useStatementMethodtoUpdatefromDatabase(){}
    public static void usePreparedStatementMethodtoInsertIntoDatabase(){
    }
    public static void usePreparedStatementMethodtoUpdateIntoDatabase(){}
    public static void usePreparedStatementMethodtoDeleteIntoDatabase(){}
    
    
}

