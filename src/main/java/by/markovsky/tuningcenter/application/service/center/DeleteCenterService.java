package by.markovsky.tuningcenter.application.service.center;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.exception.ExistOrderException;

import java.util.List;

public class DeleteCenterService {

    private DAO<Center> centerDAO = new DAOCenter();
    private DAO<Order> orderDAO = new DAOOrder();

    public boolean deleteCenter(Center center) throws ExistOrderException {
        List<Order> orderList = getAllOrdersByCenter(center.getId());

        if (orderList == null || !orderList.isEmpty()) {
            throw new ExistOrderException();
        }

        try {
            centerDAO.delete(center);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

    private List<Order> getAllOrdersByCenter(int idCenter) {
        List<Order> orderList = null;
        try {
            orderList = orderDAO.getByQuery("select o from Orders o join o.center c where c.id=" + idCenter);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return orderList;
    }

}
