package org.mrhu.smartlab.dao.impl;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.dao.UserDao;
import org.mrhu.smartlab.dao.impl.UserDaoImpl;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* UserDaoImpl Tester. 
* 
* @author mrhu 
* @since <pre>02/22/2018</pre> 
* @version 1.0 
*/ 
public class UserDaoImplTest {
    private ApplicationContext applicationContext;

    @Test
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testSaveUser() throws Exception {
        init();
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User();
        user.setPassword("111111");
        user.setUsername("huxiaozhong");
        user.setStatus(Status.USER);
        user.setName("呼啸中");
        user.setContact("1466947023");
        userDao.saveUser(user);
    }


    @Test
    public void testLoadUser() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testDeleteUser() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testUpdateUser() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testLoadUserByUserName() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGetSetHibernateTemplate() throws Exception { 
    //TODO: Test goes here... 
    } 


} 
