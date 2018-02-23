package org.mrhu.smartlab.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.service.NewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* NewsServiceImpl Tester. 
* 
* @author mrhu 
* @since <pre>02/23/2018</pre> 
* @version 1.0 
*/ 
public class NewsServiceImplTest { 

    private ApplicationContext applicationContext;
    private NewsService newsService;

    @Test
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        newsService = (NewsService) applicationContext.getBean("newsService");
    }

    @Test
    public void testGetSetNewsDao() throws Exception { 
    }


    @Test
    public void testSave() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGet() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testDelete() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testUpdate() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGetJson() throws Exception { 
    //TODO: Test goes here... 
    } 


    @Test
    public void testGetAllJson() throws Exception {
        init();
        System.out.println(newsService.getAllJson());
    }


} 
