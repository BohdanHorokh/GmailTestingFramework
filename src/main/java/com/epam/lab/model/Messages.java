package com.epam.lab.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "messages")
public class Messages {
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    @XmlElement(name = "message")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Message message : this.messages) {
            str.append(message.toString());
        }
        return str.toString();
    }
}
