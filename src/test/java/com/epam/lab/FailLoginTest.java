package com.epam.lab;

import com.epam.lab.businessobject.GmailLoginBO;
import com.epam.lab.businessobject.GmailSendMessageBO;
import com.epam.lab.model.Message;
import com.epam.lab.model.User;
import com.epam.lab.util.DataUtils;
import com.epam.lab.util.EnvironmentProperties;
import com.epam.lab.util.WebDriverSingleton;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FailLoginTest {

    @Test(dataProvider = "credentials")
    public void testGmailFunctionality(User user, List<Message> messages) {
        Message incorrectEmail = messages.get(1);
        GmailLoginBO loginBO = new GmailLoginBO();
        String accountEmail = loginBO.login(user);
        Assert.assertEquals(incorrectEmail.getTo(), accountEmail);
    }

    @DataProvider(name = "credentials", parallel = true)
    public Object[][] getCredentials() throws IOException, InvalidFormatException {
        List<User> users = DataUtils.readDataFromCSVFile(new EnvironmentProperties().getCredentialsData());
        List<Message> messages = DataUtils.readDataFromXLSXFile(new EnvironmentProperties().getMessagesDataFromXLSX());
        Object[][] objects = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            objects[i][0] = users.get(i);
            objects[i][1] = messages;
        }
        return objects;
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quit();
    }
}
