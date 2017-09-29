package com.epam.lab.businessobject;

import com.epam.lab.model.User;
import com.epam.lab.pages.GmailLoginPage;

public class GmailLoginBO {
    public String login(User user) {
        GmailLoginPage loginPage = new GmailLoginPage();
        loginPage.typeLoginAndSubmit(user.getEmail());
        loginPage.typePassAndSubmit(user.getPassword());
        return loginPage.checkLogin();
    }
}
