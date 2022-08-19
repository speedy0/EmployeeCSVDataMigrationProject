package com.sparta.coldplay.sql;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.dao.EmployeeRecords;

public class InsertEmployees {
    public static void insertEmployees(EmployeeDAO employeeDAO){
        for(int i = 0; i< EmployeeRecords.getEmployees().size(); i++){
            employeeDAO.createEmployee(EmployeeRecords.getEmployees().get(i).getEmpID(),EmployeeRecords.getEmployees().get(i).getNamePrefix(), EmployeeRecords.getEmployees().get(i).getFirstName(),
                    EmployeeRecords.getEmployees().get(i).getMiddleInitial(), EmployeeRecords.getEmployees().get(i).getLastName(), EmployeeRecords.getEmployees().get(i).getGender(),
                    EmployeeRecords.getEmployees().get(i).getEmail(), EmployeeRecords.getEmployees().get(i).getDateOfBirth(), EmployeeRecords.getEmployees().get(i).getDateOfJoining(),
                    EmployeeRecords.getEmployees().get(i).getSalary());
        }
    }
}