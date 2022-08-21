package com.sparta.coldplay.Threads;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.dao.EmployeeRecords;
import com.sparta.coldplay.dto.EmployeeDTO;
import com.sparta.coldplay.sql.ConnectionManager;
import com.sparta.coldplay.sql.SQLQueries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThreadSystem{

    static ArrayList<EmployeeDTO> employeeRec = EmployeeRecords.populateArray("src/main/resources/EmployeeRecordsLarge.csv");
    static Connection connection = ConnectionManager.connectionToDB();
    static ArrayList<Thread> threads = new ArrayList<>();
    static EmployeeDAO employeeDAO = new EmployeeDAO(connection);
    private static int counter = 0;
    public static void main(String[] args) {

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    threadInput1();
                }
            }
        });
        double timerStart = System.nanoTime();
        firstThread.start();
        while (firstThread.isAlive()){

        }

        double timerEnd = System.nanoTime();
        double finishedTimer = (timerEnd - timerStart) / 100000000;
        System.out.println("Time took to perform this action: " + finishedTimer + " seconds");
    }

    public static void threadInput1(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(SQLQueries.INSERT_INTO_DB));
            for (int i = 0; i < employeeRec.size(); i++) {
                EmployeeDTO employees = employeeRec.get(i);
                preparedStatement.setString(1, employees.getEmpID());
                preparedStatement.setString(2, employees.getNamePrefix());
                preparedStatement.setString(3, employees.getFirstName());
                preparedStatement.setString(4, employees.getMiddleInitial());
                preparedStatement.setString(5, employees.getLastName());
                preparedStatement.setString(6, employees.getGender());
                preparedStatement.setString(7, employees.getEmail());
                preparedStatement.setDate(8, Date.valueOf(employees.getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employees.getDateOfJoining()));
                preparedStatement.setInt(10, employees.getSalary());
            }

            preparedStatement.executeBatch();
            Thread.currentThread().interrupt();
        } catch (SQLException e) {
            System.out.println(counter = counter + 1);
        }
    }
}
