package com.epam.lab.pages;

import com.epam.lab.control.Button;
import com.epam.lab.control.TextHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends PageObject {
//    @FindBy(xpath = "//a[contains(@href,'https://mail.google.com/mail/u/0/#sent')]")
    @FindBy(xpath = "//a[contains(@href,'#sent')]")
    private Button sentMailButton;

//    @FindBy(xpath = "//div[@role=\"main\"]/div/div/div/table/tbody/tr/td[5]/div[2]")
    @FindBy(xpath = "//div[@role=\"main\"]/div/div/div/table/tbody/tr/td[5]")
    private Button firstIncomingMessage;

    @FindBy(xpath = "//div[@class=\"Bk\"]/div/div/div/div/div[2]/div[7]/div/div")
    private TextHolder messageText;

    public String getMessageText() {
        sentMailButton.click();
        firstIncomingMessage.click();
        return messageText.getAttribute();
    }
}
