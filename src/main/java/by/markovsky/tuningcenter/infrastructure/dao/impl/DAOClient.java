package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Client;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;

import java.util.List;

public class DAOClient extends DAOAbstract implements DAO {

    @Override
    public Client getById(int id) throws DAOException {
        Client client = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            client = session.get(Client.class, id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

    @Override
    public List<Client> getAll() throws DAOException {
        List<Client> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("From Client").list();
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
