package com.app.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {
    private static final Logger Log= Logger.getAnonymousLogger();
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSession() {
        Session session = (Session) DAO.sessionThread.get();
        if(session == null) {
            session = sessionFactory.openSession();
            DAO.sessionThread.set(session);
        }
        return session;
    }

    public void begin() {
        getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void rollback() {
        try {
            getSession().getTransaction().rollback();
        }
        catch(HibernateException ex) {
            Log.log(Level.WARNING, "Cannot rollback", ex);
        }

        try {
            getSession().close();
        }
        catch(HibernateException ex) {
            Log.log(Level.WARNING, "Cannot close", ex);
        }
        DAO.sessionThread.set(null);
    }
}
