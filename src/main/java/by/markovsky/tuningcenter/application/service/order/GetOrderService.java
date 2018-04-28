package by.markovsky.tuningcenter.application.service.order;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public class GetOrderService {

    private DAO<Order> orderDAO = new DAOOrder();

    public Order get(int id) {
        Order order = null;
        try {
            order = orderDAO.getById(id);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return order;
    }

}
