package com.sparta.coldplay.sql;

public interface SQLQueries {
    public static final String SELECT_ALL = "SELECT * FROM public.employees_db";
    public static final String INSERT_INTO_DB = "INSERT INTO public.employees_db (employee_id, title, first_name, middle_initial, last_name, gender, email, birth_date, join_date, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";

    public static final String DROP_TABLE = "DROP TABLE public.employees_db";

    public static final String TRUNCATE_TABLE = "TRUNCATE  public.employees_db";

    public static final String COUNT = "SELECT count(*) FROM public.employee_db";

    public static final String CREATE_TABLE = "CREATE TABLE public.employees_db (" +
            "employee_id VARCHAR(10),\n" +
            "title VARCHAR(10),\n" +
            "first_name VARCHAR(255),\n" +
            "middle_initial VARCHAR(1),\n" +
            "last_name VARCHAR(255),\n" +
            "gender VARCHAR(1),\n" +
            "email VARCHAR(250),\n" +
            "birth_date DATE,\n" +
            "join_date DATE,\n" +
            "salary INTEGER" +
            ");";
}