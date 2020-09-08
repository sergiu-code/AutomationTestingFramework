package com.itstep.automationpractice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private final static Logger logger = LoggerFactory.getLogger(PropertyReader.class);
    private static Properties properties;

    private PropertyReader() {
        properties = new Properties();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("application.properties").getPath();
        try {
            properties.load(new FileInputStream(rootPath));
        } catch (FileNotFoundException e) {
            logger.error("Property file not found" + e);
            throw new RuntimeException("Property file not found");
        } catch (IOException e) {
            logger.error("File can't be read" + e);
            throw new RuntimeException("File can't be read");

        }
    }

    public static Properties applicationProperties() {
        if (properties == null) {
            new PropertyReader();
        }
        return properties;
    }
}
