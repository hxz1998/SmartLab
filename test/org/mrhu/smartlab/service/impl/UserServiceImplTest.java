package org.mrhu.smartlab.service.impl;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* UserServiceImpl Tester. 
* 
* @author mrhu 
* @since <pre>02/22/2018</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest {

    private ApplicationContext applicationContext;
    private UserService userService;

    @Test
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    public void testGetSetUserDao() throws Exception {

    }


    @Test
    public void testSave() throws Exception {
        init();
        userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setPassword("111111");
        user.setUsername("zhangsan");
        user.setStatus(Status.USER);
        user.setName("呼啸中");
        user.setContact("1466947023");
        userService.save(user);
    }


    @Test
    public void testGetExampleUser() throws Exception {
        User user = new User();
        init();
        user.setUsername("huxiaozhong");
        User loadUser = userService.get(user.getUsername());
        User idUser = userService.get(loadUser);
        System.out.print(":"+idUser.getPassword() + "\n" + ":" + idUser.getId());

    }


    @Test
    public void testGetUsername() throws Exception {
        User user = new User();
        user.setPassword("111111");
        user.setUsername("huxiaozhong");
        user.setStatus(Status.USER);
        user.setName("呼啸中");
        user.setContact("1466947023");
        init();
        User loadUser = userService.get(user.getUsername());
        System.out.print(":"+loadUser.getPassword() + "\n" + ":" + loadUser.getId());
    }


    @Test
    public void testDelete() throws Exception {
        init();
        User user = new User();
        User loadUser = userService.get("xiaoming");
        user.setId(loadUser.getId());
        userService.delete(user);
    }


    @Test
    public void testUpdate() throws Exception {
        init();
        User loadUser = userService.get("huxiaozhong");
        loadUser.setName("啦啦啦");
        userService.update(loadUser);
    }


    @Test
    public void testExist() throws Exception {
        init();
        User loadUser = userService.get("xiaoming");
        boolean result = userService.exist(loadUser);
        System.out.println(result);
    }


} 
