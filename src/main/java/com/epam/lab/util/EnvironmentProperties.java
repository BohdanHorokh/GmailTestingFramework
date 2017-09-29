package com.epam.lab.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {
    private Properties properties;

    public EnvironmentProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/environment.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("url");
    }

    public String getDriverName() {
        return properties.getProperty("driver.name");
    }

    public String getPathToDriver() {
        return properties.getProperty("pathToDriver");
    }

    public String getUsersData() {
        return properties.getProperty("users.data");
    }

    public String getMessagesData() {
        return properties.getProperty("messages.data");
    }

    public String getMessagesDataFromXLSX() {
        return properties.getProperty("message.xlsx.data");
    }

    public String getCredentialsData() {
        return properties.getProperty("credentials.data");
    }

    public int getWaitingTime() {
        return new Integer(properties.getProperty("waiting.time"));
    }

    public int getMiliseconds() {
        return new Integer(properties.getProperty("time.in.miliseconds"));
    }
}
