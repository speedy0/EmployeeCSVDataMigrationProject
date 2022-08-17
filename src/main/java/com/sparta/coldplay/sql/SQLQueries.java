package com.sparta.coldplay.sql;

public interface SQLQueries {
    public static final String SELECT_ALL = "SELECT * FROM public.employee_db";
    public static final String INSERT_INTO_DB = "INSERT INTO public.employee_db (id, name_prefix, first_name, middle_initial, last_name, gender, email, date_of_birth, date_of_joining, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";

}