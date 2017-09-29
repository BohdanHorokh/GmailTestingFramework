package com.epam.lab;

import com.epam.lab.businessobject.GmailLoginBO;
import com.epam.lab.businessobject.GmailSendMessageBO;
import com.epam.lab.listener.TestNGListener;
import com.epam.lab.model.Message;
import com.epam.lab.model.User;
import com.epam.lab.util.DataUtils;
import com.epam.lab.util.EnvironmentProperties;
import com.epam.lab.util.WebDriverSingleton;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.bind.JAXBException;
import java.util.List;

@Listeners(TestNGListener.class)
public class GmailTest {

    @Test(dataProvider = "loginAccounts")
    public void testGmailFunctionality(User user, List<Message> messages) {
        Message correctEmail = messages.get(0);
        Message incorrectEmail = messages.get(1);
        GmailLoginBO loginBO = new GmailLoginBO();
        String accountEmail = loginBO.login(user);
        Assert.assertNotEquals(incorrectEmail.getTo(), accountEmail);
        GmailSendMessageBO sendMessageBO = new GmailSendMessageBO();
        sendMessageBO.createMessage(incorrectEmail);
        Assert.assertTrue(sendMessageBO.checkErrorBox());
        sendMessageBO.createMessage(correctEmail);
        Assert.assertEquals(sendMessageBO.getMessageText(), correctEmail.getText());
    }

    @DataProvider(name = "loginAccounts", parallel = true)
    public Object[][] getAccounts() throws JAXBException {
        List<User> users = DataUtils.readUsersData(new EnvironmentProperties().getUsersData());
        List<Message> messages = DataUtils.readMessagesData(new EnvironmentProperties().getMessagesData());
        Object[][] objects = new Object[users.size()][messages.size()];
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
