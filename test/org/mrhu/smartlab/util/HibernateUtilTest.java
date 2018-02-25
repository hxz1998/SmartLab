package org.mrhu.smartlab.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mrhu.smartlab.model.*;

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
        user.setName("lisi");
        user.setContact("23");
        user.setStatus(Status.ADMINISTRATOR);
        user.setUsername("lisi");
        user.setPassword("123");
        user.setStart(new Date());
        session.save(user);

        User user2 = new User();
        user2.setName("小明");
        user2.setContact("47823974912");
        user2.setStatus(Status.USER);
        user2.setUsername("xiaoming");
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
        project.setProgress(20);
        session.save(project);

        Project project2 = new Project();
        project2.setContent("这是一个新项目，开发实验室综合管理平台的项目的扩展");
        project2.setInfo("这是一个新项目");
        project2.setCreateDate(new Date());
        Query query2 = session.createQuery("from User user where user.username = 'zhangsan'");
        List<User> userList2 = query2.list();
        User user3 = userList2.get(0);
        System.out.println(user3.getId());
        project2.setPmUser(user);
        users.add(user3);
        project2.setUsers(users);
        project2.setProgress(20);
        session.save(project2);

        session.getTransaction().commit();
        session.beginTransaction();

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

        ProjectTimeline projectTimeline = new ProjectTimeline();
        projectTimeline.setInfo("begin");
        projectTimeline.setContent("开始了工程，就不要轻易停下来");
        projectTimeline.setCreateDate(new Date());
        project = (Project) session.createQuery("from Project p where p.id = :pid")
                .setParameter("pid", project.getId())
                .list()
                .get(0);
        System.out.println(project.getId());
        System.out.println(project2.getId());
        projectTimeline.setProject(project);
        session.save(projectTimeline);

        ProjectTimeline projectTimeline2 = new ProjectTimeline();
        projectTimeline2.setInfo("begin");
        projectTimeline2.setContent("开始了工程，就不要轻易停下来");
        projectTimeline2.setCreateDate(new Date());
        project2 = session.get(Project.class, project2.getId());
        projectTimeline2.setProject(project2);
        session.save(projectTimeline2);

        ProjectTimeline projectTimeline1 = new ProjectTimeline();
        projectTimeline1.setProject(project);
        projectTimeline1.setCreateDate(new Date());
        projectTimeline1.setContent("工程结束，下次再会");
        projectTimeline1.setInfo("end");
        session.save(projectTimeline1);

        ProjectTimeline projectTimeline3 = new ProjectTimeline();
        projectTimeline3.setProject(project2);
        projectTimeline3.setCreateDate(new Date());
        projectTimeline3.setContent("工程结束，下次再会");
        projectTimeline3.setInfo("end");
        session.save(projectTimeline3);

        ProjectMemberDuty projectMemberDuty = new ProjectMemberDuty();
        projectMemberDuty.setDescribe("项目经理");
        projectMemberDuty.setUser(user);
        projectMemberDuty.setProject(project);
        session.save(projectMemberDuty);

        ProjectMemberDuty projectMemberDuty1 = new ProjectMemberDuty();
        projectMemberDuty1.setProject(project);
        projectMemberDuty1.setUser(user2);
        projectMemberDuty1.setDescribe("开发");
        session.save(projectMemberDuty1);

        session.getTransaction().commit();
        session.close();

    }

}
