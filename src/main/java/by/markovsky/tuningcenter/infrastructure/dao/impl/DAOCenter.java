package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;

import java.util.List;

public class DAOCenter extends DAOAbstract implements DAO {

    @Override
    public Center getById(int id) throws DAOException {
        Center center = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            center = session.get(Center.class, id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return center;
    }

    @Override
    public List<Center> getAll() throws DAOException {
        List<Center> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("From Center").list();
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
