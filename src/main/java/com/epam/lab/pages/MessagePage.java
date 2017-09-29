package com.epam.lab.pages;

import com.epam.lab.control.Button;
import com.epam.lab.control.MessageBox;
import com.epam.lab.control.TextInput;
import org.openqa.selenium.support.FindBy;

public class MessagePage extends PageObject {
    @FindBy(name = "to")
    private TextInput toField;

    @FindBy(name = "subjectbox")
    private TextInput subjectField;

    @FindBy(xpath = "//div[contains(@class, 'Am Al editable LW-avf')]")
    private TextInput messageField;

    @FindBy(xpath = "//tr[@class='btC']/td/div/div[2]")
    private Button sendButton;

    @FindBy(xpath = "//div[contains(@class, 'T-I J-J5-Ji T-I-KE L3')]")
    private Button composeButton;

    @FindBy(xpath = "//div[contains(@class, 'Kj-JD')]")
    private MessageBox warningMessage;

    @FindBy(name = "ok")
    private Button okButton;

    @FindBy(xpath = "//table[@class=\"aoP aoC\"]/tbody/tr/td[2]/form/div[2]")
    private Button invalidEmailSpan;

    @FindBy(xpath = "//td[@class=\"eV\"]/div/div/div/span/div[2]")
    private Button deleteInvalidEmail;

    private boolean isEmailIncorrect = true;

    public boolean checkIfEmailIncorrect() {
        return isEmailIncorrect;
    }

    public void setEmailBooleanValue(boolean emailInvalid) {
        isEmailIncorrect = emailInvalid;
    }

    public void typeDataIntoToField(String email) {
        toField.sendKeys(email);
    }

    public void typeSubjectAndMessage(String subject, String messageText) {
        subjectField.sendKeys(subject);
        messageField.sendKeys(messageText);
    }

    public void pressSendButton() {
        sendButton.click();
    }

    public void pressComposeButton() {
        composeButton.click();
    }

    public boolean isWarningMessageDisplayed() {
        return warningMessage.isDisplayed();
    }

    public void pressOkButton() {
        okButton.click();
    }

    public void enterCorrectEmail(String email) {
        invalidEmailSpan.click();
        deleteInvalidEmail.click();
        toField.sendKeys(email);
    }
}
