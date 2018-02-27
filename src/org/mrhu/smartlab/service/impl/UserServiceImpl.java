package org.mrhu.smartlab.service.impl;

import org.mrhu.smartlab.dao.UserDao;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean save(User user) {
        try{
            userDao.save(user);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User get(User exampleUser) {
        return userDao.load(exampleUser);
    }

    @Override
    public User get(String username) {
        return userDao.loadByUserName(username);
    }

    @Override
    public boolean delete(User user) {
        try {
            userDao.delete(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean exist(User user) {
        User loadUser = userDao.loadByUserName(user.getUsername());
        if(loadUser != null) {
            return true;
        } else {
            return false;
        }
    }
}
