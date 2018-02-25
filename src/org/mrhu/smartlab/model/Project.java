package org.mrhu.smartlab.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@GenericGenerator(name="uuid", strategy = "uuid")
public class Project {
    private String id;
    private String info;
    private String content;
    private User pmUser;
    private Date createDate;
    private Set<User> users = new HashSet<User>();
    private int progress;

    @Id
    @GeneratedValue(generator = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_has_project",
        joinColumns = {@JoinColumn(name="project_id")},
        inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToOne
    public User getPmUser() {
        return pmUser;
    }

    public void setPmUser(User pmUser) {
        this.pmUser = pmUser;
    }

    @Column(name = "project_progress")
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
