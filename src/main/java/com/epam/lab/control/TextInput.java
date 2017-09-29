package com.epam.lab.control;

import com.epam.lab.util.EnvironmentProperties;
import org.openqa.selenium.WebElement;

public class TextInput extends Element {
    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(CharSequence... charSequences) {
        waitBeforeAction(new EnvironmentProperties().getMiliseconds());
        webElement.sendKeys(charSequences);
    }
}
