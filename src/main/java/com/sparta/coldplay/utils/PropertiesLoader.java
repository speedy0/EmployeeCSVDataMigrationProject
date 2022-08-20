package com.sparta.coldplay.utils;

import com.sparta.coldplay.logger.LoggerSystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class PropertiesLoader {
    public static String getProperty(String key){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
            LoggerSystem.getMessage(1, "Properties file has been read.");
        }catch (IOException e){
            e.printStackTrace();
            LoggerSystem.getMessage(2, e.getMessage());
        }
        return properties.getProperty(key);
    }
}