package by.markovsky.tuningcenter.application.service.order;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class DeleteOrderService {

    private DAO<Order> orderDAO = new DAOOrder();

    public boolean deleteOrder(Order order) {
        try {
            orderDAO.delete(order);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
