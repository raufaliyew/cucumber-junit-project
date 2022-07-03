package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("conf.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Failed while reading conf file");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
