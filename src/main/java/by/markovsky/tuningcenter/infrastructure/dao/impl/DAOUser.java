package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;

import java.util.List;

public class DAOUser extends DAOAbstract implements DAO {

    @Override
    public User getById(int id) throws DAOException {
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = session.get(User.class, id);
            /*user = session.load(User.class, id);*/
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() throws DAOException {
        List<User> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("From Users").list();
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
