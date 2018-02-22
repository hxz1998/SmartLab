package org.mrhu.smartlab.dto;

import org.mrhu.smartlab.model.User;

public class UserLoginDto {
    //User对象
    private User user = new User();

    //从前端表单处接收过来的对象
    private String username;
    private String password;

    public User getUser() {
        user.setUsername(username);
        user.setPassword(password);
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
}
