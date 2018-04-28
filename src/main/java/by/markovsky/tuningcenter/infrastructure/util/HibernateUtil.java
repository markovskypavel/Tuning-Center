package by.markovsky.tuningcenter.infrastructure.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().mergeProperties(ConfigHibernateUtil.getProperties())
                    .configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

}
