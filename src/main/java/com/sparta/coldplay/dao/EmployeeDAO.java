package com.sparta.coldplay.dao;

import com.sparta.coldplay.dto.EmployeeDTO;
import com.sparta.coldplay.logger.LoggerSystem;
import com.sparta.coldplay.sql.SQLQueries;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<EmployeeDTO> cleanRecordsOfEmployees = new ArrayList<>();
    private final Connection postgresConn;
    private static Statement statement;
    public static ArrayList<EmployeeDTO> getCleanRecordsOfEmployees() {
        return cleanRecordsOfEmployees;
    }


    public EmployeeDAO(Connection postgresConn){
        this.postgresConn = postgresConn;
        try {
            LoggerSystem.getMessage(1, "Creating a statement and connection using EmployeeDAO class.");
            statement = postgresConn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }

    public void printAllEmployees(){
        try {
            LoggerSystem.getMessage(1, "Printing all of the employees using SELECT query.");
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getDate(8));
                System.out.println(resultSet.getDate(9));
                System.out.println(resultSet.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }

    public void createTable()  {
        deleteTable();
        try {
            LoggerSystem.getMessage(1, "Creating a table using Create Table query.");
            PreparedStatement preparedStatement = postgresConn.prepareStatement(SQLQueries.CREATE_TABLE);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }

    public void deleteTable(){
        PreparedStatement preparedStatement = null;
        try {
            LoggerSystem.getMessage(1, "Dropping the table if exists.");
            preparedStatement = postgresConn.prepareStatement(SQLQueries.DROP_TABLE);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }

    public void truncateTable(){
        PreparedStatement preparedStatement = null;
        try {
            LoggerSystem.getMessage(1, "Trying to truncate the table.");
            preparedStatement = postgresConn.prepareStatement(SQLQueries.TRUNCATE_TABLE);
            preparedStatement.execute();
            LoggerSystem.getMessage(1, "Query has been sent out correctly for truncating the table.");
        }
        catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }

    public void createEmployee(String id, String name_prefix, String first_name, String middle_initial, String last_name, String gender,
                               String email, LocalDate date_of_birth, LocalDate date_of_joining, int salary){
        LoggerSystem.getMessage(1, "Creating an employee in EmployeeDAO class.");
        try {
            PreparedStatement preparedStatement = postgresConn.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name_prefix);
            preparedStatement.setString(3, first_name);
            preparedStatement.setString(4, middle_initial);
            preparedStatement.setString(5, last_name);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, Date.valueOf(date_of_birth));
            preparedStatement.setDate(9, Date.valueOf(date_of_joining));
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();
            LoggerSystem.getMessage(1, "Employee created and added into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
    }
}
