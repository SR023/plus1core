package fudan.plus1.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import java.util.List;


public class PersistenceManager{
    @SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new Configuration()
    .configure() // configures settings from hibernate.cfg.xml
    .buildSessionFactory();
    private static final ThreadLocal session = new ThreadLocal();
    protected PersistenceManager() {

    }
    public static Session getSession() {
        Session session = (Session) PersistenceManager.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            PersistenceManager.session.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected static void close() {
        getSession().close();
        PersistenceManager.session.set(null);
    }

}
