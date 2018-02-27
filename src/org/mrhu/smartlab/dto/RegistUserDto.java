package org.mrhu.smartlab.dto;

import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;

import java.util.Date;

public class RegistUserDto {
    private String username;
    private String password;
    private String repPassword;
    private String contact;
    private String name;

    private User user = new User();

    public User getUser() {
        user.setContact(contact);
        user.setName(name);
        user.setStatus(Status.USER);
        user.setPassword(password);
        user.setStart(new Date());
        user.setUsername(username);
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepPassword() {
        return repPassword;
    }

    public void setRepPassword(String repPassword) {
        this.repPassword = repPassword;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
