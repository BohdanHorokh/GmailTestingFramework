package com.epam.lab.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
public class Users {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    @XmlElement(name = "user")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (User user : this.users) {
            str.append(user.toString());
        }
        return str.toString();
    }
}
