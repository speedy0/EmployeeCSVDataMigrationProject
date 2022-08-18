package com.sparta.coldplay;

import com.sparta.coldplay.dao.EmployeeDAO;

public class App
{
    public static void main( String[] args )
    {
        EmployeeDAO.populateArray("src/main/resources/EmployeeRecords.csv");
        //System.out.println(EmployeeDAO.getEmployees().get(0).getLastName());
        System.out.println(EmployeeDAO.getEmployees().size());
        System.out.println(EmployeeDAO.getCorruptedEmployees().size());
        System.out.println(EmployeeDAO.getDuplicatedEmployees().size());

    }
}
