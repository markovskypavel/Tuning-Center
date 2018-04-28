package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Automobile;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;

import java.util.List;

public class DAOAutomobile extends DAOAbstract implements DAO {

    @Override
    public Automobile getById(int id) throws DAOException {
        Automobile automobile = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            automobile = session.get(Automobile.class, id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return automobile;
    }

    @Override
    public List<Automobile> getAll() throws DAOException {
        List<Automobile> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("From Automobile").list();
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
