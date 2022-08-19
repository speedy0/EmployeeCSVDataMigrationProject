package com.sparta.coldplay.loader;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.dao.EmployeeRecords;
import com.sparta.coldplay.display.print.Timer;
import com.sparta.coldplay.sql.ConnectionManager;
import com.sparta.coldplay.sql.InsertEmployees;

import java.sql.Connection;

public class EmployeeLoader {
    public static void start(){
        EmployeeRecords.populateArray("src/main/resources/EmployeeRecords.csv");

        Connection postgresConn = ConnectionManager.connectionToDB();
        EmployeeDAO employeeDAO = new EmployeeDAO(postgresConn);

        //System.out.println("Size: " + EmployeeDAO.getEmployees().size());

        employeeDAO.truncateTable();

        double start = System.currentTimeMillis();
        InsertEmployees.insertEmployees(employeeDAO);
        double finish = System.currentTimeMillis();

        System.out.println(Timer.printTimer(start, finish));

        ConnectionManager.closeConnection();

    }
}
