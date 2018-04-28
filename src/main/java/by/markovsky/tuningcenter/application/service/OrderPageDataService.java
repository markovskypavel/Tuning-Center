package by.markovsky.tuningcenter.application.service;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public class OrderPageDataService {

    private DAO<Order> orderDAO = new DAOOrder();
    private DAO<Center> centerDAO = new DAOCenter();
    private DAO<Service> serviceDAO = new DAOService();

    public List<Order> getAllOrders() {
        List<Order> orderList = null;
        try {
            orderList = orderDAO.getAll();
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return orderList;
    }

    public List<Order> getAllOrdersByLogin(String login) {
        List<Order> orderList = null;
        String query = "select o from Orders o " +
                "join o.automobile a " +
                "join a.client c " +
                "join c.user u " +
                "where u.login='" + login + "'";
        try {
            orderList = orderDAO.getByQuery(query);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return orderList;
    }

    public List<Center> getAllCenters() {
        List<Center> centerList = null;
        try {
            centerList = centerDAO.getAll();
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return centerList;
    }

    public List<Service> getAllServices() {
        List<Service> serviceList = null;
        try {
            serviceList = serviceDAO.getAll();
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return serviceList;
    }

}
