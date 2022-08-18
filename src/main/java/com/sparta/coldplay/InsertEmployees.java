package com.sparta.coldplay;

import com.sparta.coldplay.dao.EmployeeDAO;

public class InsertEmployees {
    public static void insertEmployees(EmployeeDAO employeeDAO){
        for(int i=0; i<EmployeeDAO.getEmployees().size(); i++){
            employeeDAO.createEmployee(EmployeeDAO.getEmployees().get(i).getEmpID(),EmployeeDAO.getEmployees().get(i).getNamePrefix(), EmployeeDAO.getEmployees().get(i).getFirstName(),
                    EmployeeDAO.getEmployees().get(i).getMiddleInitial(), EmployeeDAO.getEmployees().get(i).getLastName(), EmployeeDAO.getEmployees().get(i).getGender(),
                    EmployeeDAO.getEmployees().get(i).getEmail(), EmployeeDAO.getEmployees().get(i).getDateOfBirth(), EmployeeDAO.getEmployees().get(i).getDateOfJoining(),
                    EmployeeDAO.getEmployees().get(i).getSalary());
        }
    }
}