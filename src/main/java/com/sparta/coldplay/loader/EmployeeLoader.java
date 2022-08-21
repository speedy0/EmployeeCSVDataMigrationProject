package com.sparta.coldplay.loader;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.dao.EmployeeRecords;
import com.sparta.coldplay.display.print.Timer;
import com.sparta.coldplay.logger.LoggerSystem;
import com.sparta.coldplay.sql.ConnectionManager;
import com.sparta.coldplay.sql.InsertEmployees;

import java.sql.Connection;

public class EmployeeLoader {
    public static void start(){
        EmployeeRecords.populateArray("src/main/resources/EmployeeRecordsLarge.csv");

        LoggerSystem.getMessage(1, "An array was populated.");
        if (EmployeeRecords.getEmployees().size() == 0){
            LoggerSystem.getMessage(3, "Employee records are empty.");
        }

        LoggerSystem.getMessage(1, "Connecting to the database.");
        Connection postgresConn = ConnectionManager.connectionToDB();
        EmployeeDAO employeeDAO = new EmployeeDAO(postgresConn);
        LoggerSystem.getMessage(1, "Deleting the table if such exists and creating a new table.");
        employeeDAO.createTable();

        double start = System.currentTimeMillis();
        LoggerSystem.getMessage(1, "Filling an employees into the database.");
        InsertEmployees.insertEmployees(employeeDAO);
        double finish = System.currentTimeMillis();

        System.out.println(Timer.printTimer(start, finish));

        LoggerSystem.getMessage(1, "Closing the connection to the database.");
        ConnectionManager.closeConnection();
    }
}
