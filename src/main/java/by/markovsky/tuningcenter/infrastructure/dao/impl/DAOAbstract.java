package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public abstract class DAOAbstract<E> implements DAO<E> {

    protected Session session = null;

    @Override
    public void add(E obj) throws DAOException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void update(E obj) throws DAOException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(E obj) throws DAOException {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<E> getByQuery(String query) throws DAOException {
        List<E> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery(query).list();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

}
