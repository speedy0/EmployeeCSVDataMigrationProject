package com.sparta.coldplay.display.print;

public class Timer {
    public static void printTimer(double start, double end){
        System.out.println("The system took: " + ((end - start) / 1000000) + ". To perform this action.");
    }
}
