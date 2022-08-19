package com.sparta.coldplay.dao;

import com.sparta.coldplay.dto.EmployeeDTO;
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
            statement = postgresConn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAllEmployees(){
        try {
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
        }
    }

    public void createTable()  {
        deleteTable();
        try {
            PreparedStatement preparedStatement = postgresConn.prepareStatement(SQLQueries.CREATE_TABLE);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTable(){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = postgresConn.prepareStatement(SQLQueries.DROP_TABLE);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void truncateTable(){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = postgresConn.prepareStatement(SQLQueries.TRUNCATE_TABLE);
            preparedStatement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createEmployee(String id, String name_prefix, String first_name, String middle_initial, String last_name, String gender,
                               String email, LocalDate date_of_birth, LocalDate date_of_joining, int salary){
        try {
            PreparedStatement preparedStatement = postgresConn.prepareStatement(SQLQueries.INSERT_INTO_DB);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name_prefix);
            preparedStatement.setString(3, first_name);
            preparedStatement.setString(4, middle_initial);
            preparedStatement.setString(5, last_name);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, java.sql.Date.valueOf(date_of_birth));
            preparedStatement.setDate(9, Date.valueOf(date_of_joining));
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
