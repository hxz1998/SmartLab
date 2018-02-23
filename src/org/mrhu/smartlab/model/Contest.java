package org.mrhu.smartlab.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@GenericGenerator(name="uuid", strategy = "uuid")
public class Contest {

    private String id;
    private String info;
    private String content;
    private Set<User> users = new HashSet<User>();

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

    @ManyToMany
    @JoinTable(name="user_has_contest",
            joinColumns = {@JoinColumn(name="contest_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
