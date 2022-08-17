package com.sparta.coldplay.dao;

import com.sparta.coldplay.dto.EmployeeDTO;
import com.sparta.coldplay.sql.SQLQueries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private static BufferedReader bufferedReader;

    private final Connection postgresConn;
    private Statement statement;

    public EmployeeDAO(Connection postgresConn){
        this.postgresConn = postgresConn;
        try {
            statement = postgresConn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public static void populateArray(String filename){
        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] records = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(records);
                employees.add(employeeDTO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dropTable() throws SQLException {
        Statement statement = postgresConn.createStatement();
        statement.executeLargeUpdate(SQLQueries.DROP_TABLE);
        statement.close();
    }

    private void createTable() throws SQLException {
        Statement statement = postgresConn.createStatement();
        statement.executeLargeUpdate(SQLQueries.CREATE_TABLE);
        statement.close();
    }
}
