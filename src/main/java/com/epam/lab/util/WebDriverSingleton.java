package com.epam.lab.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getThreadInstance() {
        if (webDriverThreadLocal.get() != null) {
            return webDriverThreadLocal.get();
        }
        System.setProperty(new EnvironmentProperties().getDriverName(), new EnvironmentProperties().getPathToDriver());
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(new EnvironmentProperties().getWaitingTime(), TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(new EnvironmentProperties().getBaseUrl());
        webDriverThreadLocal.set(webDriver);
        return webDriverThreadLocal.get();
    }

    public static void quit() {
        try {
            webDriverThreadLocal.get().quit();
        } finally {
            webDriverThreadLocal.remove();
        }
    }
}