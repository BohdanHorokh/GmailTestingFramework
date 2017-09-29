package com.epam.lab.control;

import com.epam.lab.util.EnvironmentProperties;
import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void waitBeforeAction(int timeInMiliseconds) {
        try {
            Thread.sleep(timeInMiliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
