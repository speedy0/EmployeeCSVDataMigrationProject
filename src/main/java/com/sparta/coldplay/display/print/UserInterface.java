package com.sparta.coldplay.display.print;

import com.sparta.coldplay.dao.EmployeeDAO;
import com.sparta.coldplay.dao.EmployeeRecords;

public class UserInterface {
    public static void printCleanEmployees(){
        System.out.println("The Clean employee records : ");
        for (int i = 0; i< EmployeeRecords.getEmployees().size(); i++){
            System.out.println(EmployeeRecords.getEmployees().get(i));
        }
    }
    public static void printDuplicatedEmployees(){
        System.out.println("The Duplicated employee records : ");
        for (int i=0; i< EmployeeRecords.getDuplicatedEmployees().size(); i++){
            System.out.println(EmployeeRecords.getDuplicatedEmployees().get(i));
        }
    }
    public static void printCorruptedEmployees(){
        System.out.println("The Corrupted employee records : ");
        for (int i=0; i< EmployeeRecords.getCorruptedEmployees().size(); i++){
            System.out.println(EmployeeRecords.getCorruptedEmployees().get(i));
        }
    }

    public static void printLengthOfEmployees(){
        System.out.println(EmployeeRecords.getEmployees().size());
    }

    public static void printLengthOfCorruptedEmployees(){
        System.out.println(EmployeeRecords.getCorruptedEmployees().size());
    }

    public static void printLengthOfDuplicateEmployees(){
        System.out.println(EmployeeRecords.getDuplicatedEmployees().size());
    }
}
