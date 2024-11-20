package com.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String propertyReader(String filePath,String key)

    {
        String value = null;

        //Inputstream is required while loading into properties

        try (FileInputStream file = new FileInputStream(filePath))
        {

            // object creation for Property class
            Properties prop = new Properties();

            // load a properties file
            prop.load(file);

            //getProperty will fetch the value according to the key
            value=prop.getProperty(key);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;

    }
}
