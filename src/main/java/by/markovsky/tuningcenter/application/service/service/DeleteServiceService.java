package by.markovsky.tuningcenter.application.service.service;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.exception.ExistOrderException;

import java.util.List;

public class DeleteServiceService {

    private DAO<Service> serviceDAO = new DAOService();
    private DAO<Order> orderDAO = new DAOOrder();

    public boolean deleteService(Service service) throws ExistOrderException {
        List<Order> orderList = getAllOrdersByService(service.getId());

        if(orderList == null || !orderList.isEmpty()){
            throw new ExistOrderException();
        }

        try {
            serviceDAO.delete(service);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

    private List<Order> getAllOrdersByService(int idService) {
        List<Order> orderList = null;
        try {
            orderList = orderDAO.getByQuery("select o from Orders o join o.service s where s.id=" + idService);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return orderList;
    }

}
