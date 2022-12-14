package com.sparta.coldplay.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {
    private String empID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private Integer salary;

    public EmployeeDTO( String[] csvInput) {
        empID = csvInput[0];
        namePrefix = csvInput[1];
        firstName = csvInput[2];
        middleInitial = csvInput[3];
        lastName = csvInput[4];
        gender = csvInput[5];
        email = csvInput[6];
        this.dateOfBirth = LocalDate.parse(csvInput[7], DateTimeFormatter.ofPattern("d/M/uuuu"));
        this.dateOfJoining= LocalDate.parse(csvInput[8], DateTimeFormatter.ofPattern("d/M/uuuu"));
        this.salary = Integer.valueOf(csvInput[9]);
    }


    public String getEmpID() {
        return empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empID='" + empID + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}
