package org.mrhu.smartlab.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
public class User implements Cloneable{

    //使用UUID作为唯一ID号
    private String id;
    private String name;
    private String username;
    private String password;
    private String contact;
    //定义了系统中身份
    private Status status;
    private Date start;
    private Date leave;


    @Override
    public Object clone() {
        User user = null;
        user.setContact(this.getContact());
        user.setId(this.getId());
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setUsername(this.getUsername());
        return user;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "user_start")
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "user_leave")
    public Date getLeave() {
        return leave;
    }

    public void setLeave(Date leave) {
        this.leave = leave;
    }
}
