package com.epam.lab.control;

import org.openqa.selenium.WebElement;

public class MessageBox extends Element {
    public MessageBox(WebElement webElement) {
        super(webElement);
    }

    public boolean isDisplayed() {
        return webElement.isEnabled();
    }
}
