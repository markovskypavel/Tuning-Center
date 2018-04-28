package by.markovsky.tuningcenter.application.service.order;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.constant.OrderStatus;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class ConfirmOrderService {

    private DAO<Order> orderDAO = new DAOOrder();

    public boolean approveOrder(Order order) {
        return confirmOrder(order, OrderStatus.READY);
    }

    public boolean declineOrder(Order order) {
        return confirmOrder(order, OrderStatus.NOT_READY);
    }

    private boolean confirmOrder(Order order, boolean orderStatus) {
        try {
            order.setStatus(orderStatus);
            orderDAO.update(order);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
