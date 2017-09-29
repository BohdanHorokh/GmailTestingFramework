package com.epam.lab.stepsdefenition;

import com.epam.lab.pages.GmailLoginPage;
import com.epam.lab.util.WebDriverSingleton;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginStep {
    private GmailLoginPage loginPage = new GmailLoginPage();

    @Given("^User enter username as \"([^\"]*)\" and submit$")
    public void userEnterUsernameAsAndSubmit(String email) throws Throwable {
        loginPage.typeLoginAndSubmit(email);
    }

    @Given("^user enter password as \"([^\"]*)\" and submit$")
    public void userEnterPasswordAsAndSubmit(String pass) throws Throwable {
        loginPage.typePassAndSubmit(pass);
    }

    @Then("^Gmail home page is opened$")
    public void gmailHomePageIsOpened() throws Throwable {
        Assert.assertEquals("horokh.bohdan@gmail.com", loginPage.checkLogin());
    }

    @After
    public void after() {
        WebDriverSingleton.quit();
    }
}
