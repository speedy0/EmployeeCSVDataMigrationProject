package com.sparta.coldplay;

import com.sparta.coldplay.display.print.Timer;
import com.sparta.coldplay.loader.EmployeeLoader;

public class App
{
    public static void main( String[] args )
    {
        double start = System.currentTimeMillis();
        EmployeeLoader.start();
        double end = System.currentTimeMillis();
        System.out.println(Timer.printTimer(start, end));
    }
}