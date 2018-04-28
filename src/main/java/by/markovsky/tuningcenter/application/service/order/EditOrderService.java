package by.markovsky.tuningcenter.application.service.order;

import by.markovsky.tuningcenter.domain.entity.tuningservice.*;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOOrder;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class EditOrderService {

    private DAO<Order> orderDAO = new DAOOrder();
    private DAO<Center> centerDAO = new DAOCenter();
    private DAO<Service> serviceDAO = new DAOService();

    public boolean editOrder(Order order, String name, String surname, String passport, long telephone,
                            String model, int year, int idCenter, int idService) {
        try {
            Center center = centerDAO.getById(idCenter);
            Service service = serviceDAO.getById(idService);
            Automobile automobile = order.getAutomobile();
            Client client = automobile.getClient();

            automobile.setModel(model);
            automobile.setYear(year);
            client.setName(name);
            client.setSurname(surname);
            client.setPassport(passport);
            client.setTelephone(telephone);
            order.setCenter(center);
            order.setService(service);

            orderDAO.update(order);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
