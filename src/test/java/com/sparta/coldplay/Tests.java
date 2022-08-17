package com.sparta.coldplay;

import com.sparta.coldplay.dto.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tests {

    FileReader fileReader;
    String filename = "EmployeeRecords.csv";
    BufferedReader bufferedReader;
    String[] records;
    EmployeeDTO employeeDTO;
    ArrayList<EmployeeDTO> employees = new ArrayList<>();
    @BeforeEach
    public void setup(){
        try {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                records = line.split(",");
                employeeDTO = new EmployeeDTO(records);
                employees.add(employeeDTO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Get the name of the first employee")
    public void getName(){
        Assertions.assertEquals(employees.get(0).getFirstName(), "Serafina");
    }

    @Test
    @DisplayName("Get the gender of the ninth employee")
    public void getGender(){
        Assertions.assertEquals(employees.get(9).getGender(), "F");
    }
}