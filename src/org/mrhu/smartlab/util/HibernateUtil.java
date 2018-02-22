/**
 * @apiNote SessionFactory工厂，获取静态sessionFactory
 * @since 2018年2月17日22:02:29
 */
package org.mrhu.smartlab.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
