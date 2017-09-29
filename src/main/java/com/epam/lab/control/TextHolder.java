package com.epam.lab.control;

import com.epam.lab.util.EnvironmentProperties;
import org.openqa.selenium.WebElement;

public class TextHolder extends Element {
    public TextHolder(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        return webElement.getText();
    }

    public String getAttribute() {
        waitBeforeAction(new EnvironmentProperties().getMiliseconds());
        return webElement.getAttribute("innerText");
    }
}

