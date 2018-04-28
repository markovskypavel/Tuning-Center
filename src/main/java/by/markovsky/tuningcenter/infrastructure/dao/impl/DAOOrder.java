package by.markovsky.tuningcenter.infrastructure.dao.impl;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.util.HibernateUtil;

import java.util.List;

public class DAOOrder extends DAOAbstract implements DAO {

    @Override
    public Order getById(int id) throws DAOException {
        Order order = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            order = session.get(Order.class, id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return order;
    }

    @Override
    public List<Order> getAll() throws DAOException {
        List<Order> list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createQuery("From Orders").list();
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
