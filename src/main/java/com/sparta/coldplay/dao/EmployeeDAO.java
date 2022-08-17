package com.sparta.coldplay.dao;

import com.sparta.coldplay.dto.EmployeeDTO;
import com.sparta.coldplay.sql.SQLQueries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private static ArrayList<EmployeeDTO> corruptedEmployees = new ArrayList<>();
    private static ArrayList<EmployeeDTO> duplicatedEmployees = new ArrayList<>();

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
    public static ArrayList<EmployeeDTO> getCorruptedEmployees() {
        return corruptedEmployees;
    }
    public static ArrayList<EmployeeDTO> getDuplicatedEmployees() {
        return duplicatedEmployees;
    }

    public static void populateArray(String filename){
        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] records = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(records);
                boolean validated = validateRecord(employeeDTO);
                boolean duplicate = checkDuplication(employeeDTO);
                if (validated && !duplicate){
                    employees.add(employeeDTO);
                } else if (duplicate){
                    duplicatedEmployees.add(employeeDTO);
                } else{
                    corruptedEmployees.add(employeeDTO);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkDuplication(EmployeeDTO employee) {
        return employees.stream()
                .anyMatch(emp -> emp.toString() == employee.toString());
        /*for (EmployeeDTO emp: employees){
            if (emp.toString() == employee.toString()){
                return true;
            }
        }
        return false;*/
    }

    private static boolean validateRecord(EmployeeDTO records) {
        if (records.getMiddleInitial().equals("FALSE") ||
                records.getGender().equals("X") ||
                records.getSalary() < 0 ||
                records.getDateOfBirth().compareTo(LocalDate.now()) > 0 ||
                records.getDateOfJoining().compareTo(LocalDate.now()) > 0){
            return false;
        }
        return true;
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
