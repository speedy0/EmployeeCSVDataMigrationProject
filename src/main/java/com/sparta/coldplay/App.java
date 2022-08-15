package com.sparta.coldplay;

import com.sparta.coldplay.dao.EmployeeDAO;

public class App
{
    public static void main( String[] args )
    {
        EmployeeDAO.populateArray("EmployeeRecords.csv");
        System.out.println(EmployeeDAO.getEmployees().get(0).getLastName());
    }
}
