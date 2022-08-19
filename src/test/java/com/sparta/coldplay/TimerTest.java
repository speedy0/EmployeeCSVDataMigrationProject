package com.sparta.coldplay;

import com.sparta.coldplay.display.print.Timer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimerTest {
    @Test
    @DisplayName("Is the time returned contain correct message")
    void isTheTimeReturnedContainCorrectMessage(){
        double start = System.nanoTime();
        // Random operation
        for (int i = 0; i < 100; i++){
            continue;
        }
        double end = System.nanoTime();
        Assertions.assertTrue(Timer.printTimer(start, end).contains("The system took: "));
    }

    @Test
    @DisplayName("When 0 is provided instead of System.nanoTime as a start")
    void when0IsProvidedInsteadOfSystemNanoTimeAsAStart(){
        double start = 0;
        double end = System.nanoTime();
        String expected = "The system cannot calculate the time when 0 is provided.";
        Assertions.assertEquals(expected, Timer.printTimer(start, end));
    }

    @Test
    @DisplayName("When 0 is provided instead of a System.nanoTime as an end")
    void when0IsProvidedInsteadOfASystemNanoTimeAsAnEnd(){
        double start = System.nanoTime();
        double end = 0;
        String expected = "The system cannot calculate the time when 0 is provided.";
        Assertions.assertEquals(expected, Timer.printTimer(start, end));
    }

    @Test
    @DisplayName("IsTheTimeReturnedMoreThan0")
    void isTheTimeReturnedMoreThan0(){
        double start = System.nanoTime();
        // Random operation
        for (int i = 0; i < 100; i++){
            continue;
        }
        double end = System.nanoTime();

        String returnValue = Timer.printTimer(start, end);
        String returnValWithoutFront = returnValue.replace("The system took: ", "");
        String returnVal = returnValWithoutFront.replace(". To perform this action.", "");
    Assertions.assertTrue(Double.valueOf(returnVal) > 0);
    }


}
