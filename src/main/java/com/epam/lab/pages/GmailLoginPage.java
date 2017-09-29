package com.epam.lab.pages;

import com.epam.lab.control.Button;
import com.epam.lab.control.TextHolder;
import com.epam.lab.control.TextInput;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends PageObject {
    @FindBy(id = "identifierId")
    private TextInput emailInput;

    @FindBy(id = "identifierNext")
    private Button loginNextButton;

    @FindBy(name = "password")
    private TextInput passInput;

    @FindBy(id = "passwordNext")
    private Button passNextButton;

    @FindBy(xpath = "//div[@id='gb']/div/div/div[2]/div[5]/div/a")
    private Button accountButton;

    @FindBy(xpath = "//div[@class=\"gb_qb\"]/div/div[2]")
    private TextHolder accountName;

    public void typeLoginAndSubmit(String email) {
        emailInput.sendKeys(email);
        loginNextButton.click();
    }

    public void typePassAndSubmit(String pass) {
        passInput.sendKeys(pass);
        passNextButton.click();
    }

    public String checkLogin() {
        accountButton.click();
        return accountName.getText();
    }
}
