package by.markovsky.tuningcenter.application.service.order;

import by.markovsky.tuningcenter.domain.entity.tuningservice.*;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.OrderStatus;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class AddOrderService {

    private DAO<Order> orderDAO = new DAOOrder();
    private DAO<Center> centerDAO = new DAOCenter();
    private DAO<Service> serviceDAO = new DAOService();

    public boolean addOrder(String name, String surname, String passport, long telephone,
                            String model, int year, int idCenter, int idService, User user) {
        try {
            Center center = centerDAO.getById(idCenter);
            Service service = serviceDAO.getById(idService);
            Client client = new Client(name, surname, passport, telephone, user);
            Automobile automobile = new Automobile(model, year, client);
            Order order = new Order(service, center, automobile, OrderStatus.NOT_READY);

            orderDAO.add(order);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
