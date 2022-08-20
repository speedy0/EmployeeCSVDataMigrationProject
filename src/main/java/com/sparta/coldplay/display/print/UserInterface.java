package com.sparta.coldplay.display.print;

import com.sparta.coldplay.dao.EmployeeRecords;
import com.sparta.coldplay.logger.LoggerSystem;

public class UserInterface {
    public static void printCleanEmployees(){
        LoggerSystem.getMessage(1, "Printing clean employee records.");
        System.out.println("The Clean employee records : ");
        for (int i = 0; i< EmployeeRecords.getEmployees().size(); i++){
            System.out.println(EmployeeRecords.getEmployees().get(i));
        }
    }
    public static void printDuplicatedEmployees(){
        LoggerSystem.getMessage(1, "Printing duplicated employee records.");
        System.out.println("The Duplicated employee records : ");
        for (int i=0; i< EmployeeRecords.getDuplicatedEmployees().size(); i++){
            System.out.println(EmployeeRecords.getDuplicatedEmployees().get(i));
        }
    }
    public static void printCorruptedEmployees(){
        LoggerSystem.getMessage(1, "Printing corrupted employee records.");
        System.out.println("The Corrupted employee records : ");
        for (int i=0; i< EmployeeRecords.getCorruptedEmployees().size(); i++){
            System.out.println(EmployeeRecords.getCorruptedEmployees().get(i));
        }
    }

    public static void printLengthOfEmployees(){
        LoggerSystem.getMessage(1, "Printing the size of clean employee records.");
        System.out.println(EmployeeRecords.getEmployees().size());
    }

    public static void printLengthOfCorruptedEmployees(){
        LoggerSystem.getMessage(1, "Printing the size of corrupted employee records.");
        System.out.println(EmployeeRecords.getCorruptedEmployees().size());
    }

    public static void printLengthOfDuplicateEmployees(){
        LoggerSystem.getMessage(1, "Printing the size of duplicated employee records.");
        System.out.println(EmployeeRecords.getDuplicatedEmployees().size());
    }
}
