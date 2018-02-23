package org.mrhu.smartlab.dao.impl;

import org.mrhu.smartlab.dao.UserDao;
import org.mrhu.smartlab.model.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("userDao")
public class UserDaoImpl implements UserDao {

    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public void delete(User user) {
        hibernateTemplate.delete(user);
    }

    @Override
    public User update(User user) {
        if(user != null) {
            User beforeChange = hibernateTemplate.load(User.class, user.getId());
            hibernateTemplate.update(user);
            return beforeChange;
        } else {
            return null;
        }
    }

    @Override
    public User loadByUserName(String username) {
        List<User> users = (List<User>) hibernateTemplate.find("from User user where user.username = ?", username);
        if(users.size() == 1) {
            User loadUser = users.get(0);
            return loadUser;
        } else {
            return null;
        }
    }

    @Override
    public User load(User exampleUser) {
        if(exampleUser != null) {
            User user = hibernateTemplate.get(User.class, exampleUser.getId());
            return user;
        } else {
            return null;
        }
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
