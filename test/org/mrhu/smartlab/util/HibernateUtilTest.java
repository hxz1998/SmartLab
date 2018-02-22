package org.mrhu.smartlab.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mrhu.smartlab.model.Status;
import org.mrhu.smartlab.model.User;
import org.mrhu.smartlab.util.HibernateUtil;

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
        Session session = sessionFactory.getCurrentSession();
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

} 
