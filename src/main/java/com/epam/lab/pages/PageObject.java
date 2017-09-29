package com.epam.lab.pages;

import com.epam.lab.util.CustomFieldDecorator;
import com.epam.lab.util.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public PageObject(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public PageObject() {
        this(WebDriverSingleton.getThreadInstance());
    }
}


