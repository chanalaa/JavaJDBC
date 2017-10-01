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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private static String url = "jdbc:postgresql://localhost:5432/Chan";
    private static String user = "Chan";
    private static String password = "";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String filepath = "/Users/Chan/NetBeansProjects/PostgreSQLJDBC/src/com/postgresqltutorial/grades.txt";
        Scanner scan = new Scanner(new File(filepath));
        try {
            connection();
            //usePreparedStatementMethodtoInsertIntoDatabase();
            usePreparedStatementMethodtoUpdateIntoDatabase();
            readFromDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection connection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void createTableFromDatabase() {
    } // leave this one till last

    public static void readFromDatabase() throws SQLException {
        PreparedStatement preparedStatement = connection().prepareStatement("select * from histogram");
        ResultSet result = preparedStatement.executeQuery();
          
          while (result.next()) {
              String numbers = result.getString("number"); 
              System.out.println(numbers);
          }
    }

    public static void useStatementMethodtoInsertIntoDatabase() throws SQLException {
        Statement statement = connection().createStatement();
        statement.executeUpdate("INSERT into histogram (id, number) values (101, 88)");
    }

    public static void useStatementMethodtoDeletefromDatabase() throws SQLException {
        Statement statement = connection().createStatement();
        statement.executeUpdate("DELETE from histogram where id = 101");
    }

    public static void useStatementMethodtoUpdatefromDatabase() throws SQLException {
        Statement statement = connection().createStatement();
        statement.executeUpdate("UPDATE histogram values (101, 99)");
    }

    public static void usePreparedStatementMethodtoInsertIntoDatabase() throws SQLException {
        PreparedStatement preparedStatement = connection().prepareStatement("INSERT into histogram (id, number) VALUES (?,?)");
        preparedStatement.setInt(1, 102);
        preparedStatement.setInt(2, 99);
        preparedStatement.executeUpdate();
    }

    public static void usePreparedStatementMethodtoUpdateIntoDatabase() throws SQLException {
        PreparedStatement preparedStatement = connection().prepareStatement("UPDATE histogram set number=? WHERE id=?");
        preparedStatement.setInt(1, 102);
        preparedStatement.setInt(2, 111);
        preparedStatement.executeUpdate();
    }

    public static void usePreparedStatementMethodtoDeleteIntoDatabase() throws SQLException  {
        PreparedStatement preparedStatement = connection().prepareStatement("DELETE from histogram where id = 102");
        preparedStatement.executeUpdate();
    }

}
