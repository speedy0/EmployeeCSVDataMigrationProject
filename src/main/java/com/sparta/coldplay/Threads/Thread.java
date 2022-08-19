package com.sparta.coldplay.Threads;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.sql.ConnectionManager;
import com.sparta.coldplay.sql.InsertEmployees;

import java.sql.Connection;
import java.util.ArrayList;

public class Thread implements Runnable{
    private final ArrayList<EmployeeDAO> employees;
    private final Connection connection;

    public Thread(ArrayList<EmployeeDAO> employees) {
        this.employees = employees;
        this.connection = ConnectionManager.connectionToDB();
    }
    @Override
    public void run() {
        EmployeeDAO emp = new EmployeeDAO(connection);
        for (EmployeeDAO employee : employees) {
            InsertEmployees.insertEmployees(employee);
        }
    }

    private static int counter = 0;


    public static void numberOfThreads (int threadAmount){
        for (int i = 0; i < threadAmount; i++) {
            //Thread thread = new Thread(new Thread());
        }
    }
}
