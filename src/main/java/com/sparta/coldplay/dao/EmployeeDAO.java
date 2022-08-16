package com.sparta.coldplay.dao;

import com.sparta.coldplay.dto.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeDAO {
    private static ArrayList<EmployeeDTO> employees = new ArrayList<>();
    private static BufferedReader bufferedReader;

    public static ArrayList<EmployeeDTO> getEmployees() {
        return employees;
    }

    public static void populateArray(String filename){
        try {
            FileReader fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] records = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(records);
                employees.add(employeeDTO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
