package com.epam.lab.control;

import com.epam.lab.util.EnvironmentProperties;
import org.openqa.selenium.WebElement;

public class Button extends Element {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        waitBeforeAction(new EnvironmentProperties().getMiliseconds());
        webElement.click();
    }
}
