package org.mrhu.smartlab.service;

import org.mrhu.smartlab.dao.UserDao;
import org.mrhu.smartlab.dao.impl.UserDaoImpl;
import org.mrhu.smartlab.model.User;

public interface UserService {

    /**
     * 调用Dao对象，进行持久化对象操作
     * @param user 要持久化的对象
     * @return 是否持久化成功
     */
    boolean save(User user);

    /**
     * 调用Dao对象，进行查询操作
     * @param exampleUser 要查询对象的模型
     * @return 获取到查询对象
     */
    User get(User exampleUser);

    /**
     * 重载方法，根据提供的用户名查找
     * @param username 提供的用户名
     * @return 查找到的对象
     */
    User get(String username);

    /**
     * 删除指定的User对象
     * @param user 要删除的对象
     * @return 是否删除成功
     */
    boolean delete(User user);

    /**
     * 更新对象操作
     * @param user 要更新的对象最新状态
     * @return 原有的对象状态
     */
    User update(User user);

    /**
     * 查询对象是否存在于数据库中
     * @param user 要查询的对象
     * @return 对象是否存在
     */
    boolean exist(User user);
}
