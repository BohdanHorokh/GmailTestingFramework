package com.epam.lab.businessobject;

import com.epam.lab.model.Message;
import com.epam.lab.pages.GmailHomePage;
import com.epam.lab.pages.MessagePage;

public class GmailSendMessageBO {
    private MessagePage messagePage = new MessagePage();

    public void createMessage(Message message) {
        if (messagePage.checkIfEmailIncorrect()) {
            messagePage.pressComposeButton();
            messagePage.typeDataIntoToField(message.getTo());
            messagePage.typeSubjectAndMessage(message.getSubject(), message.getText());
            messagePage.pressSendButton();
        } else {
            messagePage.pressOkButton();
            messagePage.enterCorrectEmail(message.getTo());
            messagePage.pressSendButton();
        }
    }

    public boolean checkErrorBox() {
        if (messagePage.isWarningMessageDisplayed()) {
            messagePage.setEmailBooleanValue(false);
            return true;
        }
        return false;
    }

    public String getMessageText() {
        GmailHomePage gmailHomePage = new GmailHomePage();
        return gmailHomePage.getMessageText();
    }
}

