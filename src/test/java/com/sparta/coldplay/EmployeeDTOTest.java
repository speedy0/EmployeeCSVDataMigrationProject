package com.sparta.coldplay;

import com.sparta.coldplay.dao.EmployeeRecords;
import com.sparta.coldplay.dto.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmployeeDTOTest {
    @Test
    @DisplayName("Does input to EmployeeDTO returns correct data")
    void doesInputToEmployeeDtoReturnsCorrectData(){
        String[] dummyInput = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO emp = new EmployeeDTO(dummyInput);
        Assertions.assertTrue(
                dummyInput[0] == emp.getEmpID() &&
                dummyInput[1] == emp.getNamePrefix() &&
                dummyInput[2] == emp.getFirstName() &&
                dummyInput[3] == emp.getMiddleInitial() &&
                dummyInput[4] == emp.getLastName() &&
                dummyInput[5] == emp.getGender() &&
                dummyInput[6] == emp.getEmail() &&
                        "1995-09-24".equals(String.valueOf(emp.getDateOfBirth())) &&
                        "2022-07-17".equals(String.valueOf(emp.getDateOfJoining() )) &&
                        Integer.valueOf(dummyInput[9]) == emp.getSalary());
    }

    @Test
    @DisplayName("Check datatypes are correct without salary")
    void checkDatatypesAreCorrectWithoutSalary(){
        String[] dummyInput = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO emp = new EmployeeDTO(dummyInput);
        Assertions.assertTrue(emp.getEmpID() instanceof String &&
                emp.getNamePrefix() instanceof String &&
                emp.getFirstName() instanceof String &&
                emp.getMiddleInitial() instanceof String &&
                emp.getLastName() instanceof String &&
                emp.getGender() instanceof String &&
                emp.getEmail() instanceof String &&
                emp.getDateOfBirth() instanceof LocalDate &&
                emp.getDateOfJoining() instanceof LocalDate);
    }

    @Test
    @DisplayName("Check whether salary is more than 0")
    void checkWhetherSalaryIsMoreThan0(){
        String[] dummyInput = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO emp = new EmployeeDTO(dummyInput);
        Assertions.assertTrue(Integer.valueOf(emp.getSalary()) > 0);
    }

    @Test
    @DisplayName("Give validate data")
    public void validateData(){
        String[] record = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertTrue(EmployeeRecords.validateRecord(employeeDTO));
    }

    @Test
    @DisplayName("Give invalidate salary")
    public void invalidateSalary(){
        String[] record = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "-19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertFalse(EmployeeRecords.validateRecord(employeeDTO));
    }

    @Test
    @DisplayName("Give invalidate date of birth")
    public void invalidateDOB(){
        String[] record = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/2025", "17/07/2022", "19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertFalse(EmployeeRecords.validateRecord(employeeDTO));
    }

    @Test
    @DisplayName("Give invalidate date of join")
    public void invalidateDOJ(){
        String[] record = {"123456", "A", "Alex", "J", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2023", "19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertFalse(EmployeeRecords.validateRecord(employeeDTO));
    }

    @Test
    @DisplayName("Give invalidate middle initial")
    public void invalidateMiddleInitial(){
        String[] record = {"123456", "A", "Alex", "FALSE", "Nap", "M", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertFalse(EmployeeRecords.validateRecord(employeeDTO));
    }

    @Test
    @DisplayName("Give invalidate gender")
    public void invalidateGender(){
        String[] record = {"123456", "A", "Alex", "J", "Nap", "X", "anapieralski@spartaglobal.com", "24/09/1995", "17/07/2022", "19000"};
        EmployeeDTO employeeDTO = new EmployeeDTO(record);
        Assertions.assertFalse(EmployeeRecords.validateRecord(employeeDTO));
    }
}
