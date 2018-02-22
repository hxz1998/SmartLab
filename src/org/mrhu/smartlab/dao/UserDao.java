package org.mrhu.smartlab.dao;

import org.mrhu.smartlab.model.User;

public interface UserDao {

    /**
     * 持久化User对象到数据库中
     * @param user 要持久化的user对象
     */
    void saveUser(User user);

    /**
     * 从数据库中获取对应的User出来
     * @param exampleUser 要获取User对象的特征对象
     * @return 返回要获取的User对象
     */
    User loadUser(User exampleUser);

    /**
     * 从数据库中删除指定User对象
     * @param user 要删除的User对象
     */
    void deleteUser(User user);

    /**
     * 更新数据库中的User对象
     * @param user 要更新的User对象
     * @return 更改前的User对象
     */
    User updateUser(User user);

    /**
     * 从数据库中获取指定用户名的User对象
     * @param username 指定的用户名
     * @return 获取到的User对象
     */
    User loadUserByUserName(String username);

}
