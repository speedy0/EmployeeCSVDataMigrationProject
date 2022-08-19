package com.sparta.coldplay.display.print;

public class Timer {
    public static String printTimer(double start, double end){
        if (start == 0 || end == 0){
            return "The system cannot calculate the time when 0 is provided.";
        }
        return "The system took: " + calculate(start, end) + ". To perform this action.";
    }

    private static double calculate(double start, double end){
        double totalTimeTaken = end - start;
        return totalTimeTaken / 1000;
    }
}
