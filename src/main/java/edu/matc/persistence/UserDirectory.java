package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDirectory {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all users", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    public User getUser(String login) {
        User user = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            user = (User) session.get(User.class, login);
        } catch (HibernateException he) {
            log.error("Error getting user with id: " + login, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public User addUser(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = new User(user.getLogin(), user.getFirstName(), user.getLastName());
            session.save(user);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of user: " + user, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public void deleteUser(String login){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, login);
            session.delete(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            log.error("error deleting user", e);
        }finally {
            session.close();
        }
    }

    public void updateUser(User user) {
        Transaction transaction = null;
        Session session= null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Could not update user: " + user, he2);
                }
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

}
