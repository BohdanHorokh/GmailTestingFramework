package com.epam.lab.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class Message {
    private String to;
    private String subject;
    private String text;

    public String getTo() {
        return to;
    }

    @XmlElement(name = "to")
    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    @XmlElement(name = "subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    @XmlElement(name = "text")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("to='").append(to).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
