package com.sparta.coldplay.sql;

public interface SQLQueries {
    static final String DROP_TABLE = "DROP TABLE IF EXISTS EmployeeRecords";
    static final String CREATE_TABLE = "CREATE TABLE EmployeeRecords(\n" +
            "    employeeId INT,\n" +
            "    title VARCHAR(10),\n" +
            "    first_name VARCHAR(45),\n" +
            "    middle_initial VARCHAR(1),\n" +
            "    last_name VARCHAR(45),\n" +
            "    gender VARCHAR(1),\n" +
            "    email_address VARCHAR(50),\n" +
            "    date_of_birth DATE,\n" +
            "    date_of_joining DATE,\n" +
            "    salary INT,\n" +
            "    PRIMARY KEY (employeeId)\n" +
            ")";

    public static final String SELECT_ALL = "SELECT * FROM public.employee_db";
    public static final String INSERT_INTO_DB = "INSERT INTO public.employee_db (id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";

}