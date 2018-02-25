package org.mrhu.smartlab.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.model.*;
import org.mrhu.smartlab.util.HibernateUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* HibernateUtil Tester. 
* 
* @author mrhu 
* @since <pre>02/22/2018</pre> 
* @version 1.0 
*/ 
public class HibernateUtilTest { 

    @Test
    public void testGetSessionFactory() throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
    }

    @Test
    public void testAddUser() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = new User();
        user.setPassword("111111");
        user.setUsername("xiaoming");
        user.setStatus(Status.USER);
        user.setName("呼啸中");
        user.setContact("1466947023");
        session.save(user);
        session.getTransaction().commit();
    }

    @Test
    public void testAddAdmin() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = new User();
        user.setPassword("111111");
        user.setUsername("liuliuliu");
        user.setStatus(Status.ADMINISTRATOR);
        user.setName("呼啸中");
        user.setContact("1466947023");
        session.save(user);
        session.getTransaction().commit();
    }

    @Test
    public void testInitDate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setName("王五");
        user.setContact("23");
        user.setStatus(Status.ADMINISTRATOR);
        user.setUsername("wangwu");
        user.setPassword("123");
        user.setStart(new Date());
        session.save(user);

        User user2 = new User();
        user2.setName("马六");
        user2.setContact("47823974912");
        user2.setStatus(Status.USER);
        user2.setUsername("maliu");
        user2.setPassword("123");
        user2.setStart(new Date());
        session.save(user2);
        session.getTransaction().commit();


        session.beginTransaction();
        Contest contest = new Contest();
        contest.setContent("这是一个比赛，关于SmartLab的开发大赛");
        contest.setInfo("这是一个比赛");
        Set<User> users = new HashSet<>();
        users.add(user);
        users.add(user2);
        contest.setUsers(users);
        session.save(contest);

        Project project = new Project();
        project.setContent("这是一个项目，开发实验室综合管理平台的项目");
        project.setInfo("这是一个项目");
        project.setCreateDate(new Date());
        Query query = session.createQuery("from User user where user.username = 'zhangsan'");
        List<User> userList = query.list();
        user = userList.get(0);
        System.out.println(user.getId());
        project.setPmUser(user);
        project.setUsers(users);
        session.save(project);

        News news = new News();
        news.setContent("这是一个新闻，关于最新项目进展的新闻");
        news.setCreateDate(new Date());
        news.setTitle("项目进展新闻");
        news.setUser(user2);
        session.save(news);

        Report report = new Report();
        report.setContent("这是一个报告，年度报告");
        report.setCreateDate(new Date());
        report.setTitle("年度报告");
        report.setUser(user2);
        session.save(report);

        Honor honor = new Honor();
        honor.setContent("这是一个荣誉，全部人的荣誉");
        honor.setCreateDate(new Date());
        honor.setInfo("这是荣誉");
        honor.setUsers(users);
        session.save(honor);

        Document document = new Document();
        document.setContent("这是一个文档");
        document.setCreateDate(new Date());
        document.setInfo("文档");
        document.setUser(user);
        session.save(document);

        session.getTransaction().commit();
        session.close();

    }

}
