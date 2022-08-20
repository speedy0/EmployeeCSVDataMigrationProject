package com.sparta.coldplay.logger;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSystem {
    private static final Logger logger= Logger.getLogger("logger");

    private static void setLogger(Level level, String message){
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        if (/* level == Level.INFO ||*/
                level == Level.SEVERE ||
                        level == Level.WARNING){
            try{
                FileHandler fileHandler = new FileHandler("src/main/resources/logs/logs.log", true);
                fileHandler.setLevel(Level.ALL);
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
                saveLogs(logger, level, message);
                fileHandler.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveLogs(Logger logger, Level level, String message){
        logger.log(level, message);
    }

    public static void getMessage(int level, String message){
        switch (level){
            case 1 -> setLogger(Level.INFO, message);
            case 2 -> setLogger(Level.SEVERE, message);
            case 3 -> setLogger(Level.WARNING, message);
            default -> System.out.println("No correct level was introduced.");
        }
    }
}
