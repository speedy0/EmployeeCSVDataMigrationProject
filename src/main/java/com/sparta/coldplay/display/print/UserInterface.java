package com.sparta.coldplay.display.print;

import com.sparta.coldplay.dao.EmployeeDAO;

public class UserInterface {
    public static void printCleanEmployees(){
        System.out.println("The Clean employee records : ");
        for (int i=0; i< EmployeeDAO.getEmployees().size(); i++){
            System.out.println(EmployeeDAO.getEmployees().get(i));
        }
    }
    public static void printDuplicatedEmployees(){
        System.out.println("The Duplicated employee records : ");
        for (int i=0; i< EmployeeDAO.getDuplicatedEmployees().size(); i++){
            System.out.println(EmployeeDAO.getDuplicatedEmployees().get(i));
        }
    }
    public static void printCorruptedEmployees(){
        System.out.println("The Corrupted employee records : ");
        for (int i=0; i< EmployeeDAO.getCorruptedEmployees().size(); i++){
            System.out.println(EmployeeDAO.getCorruptedEmployees().get(i));
        }
    }

    public static void printLengthOfEmployees(){
        System.out.println(EmployeeDAO.getEmployees().size());
    }

    public static void printLengthOfCorruptedEmployees(){
        System.out.println(EmployeeDAO.getCorruptedEmployees().size());
    }

    public static void printLengthOfDuplicateEmployees(){
        System.out.println(EmployeeDAO.getDuplicatedEmployees().size());
    }
}
