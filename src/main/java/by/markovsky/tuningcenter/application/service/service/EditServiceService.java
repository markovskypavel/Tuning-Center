package by.markovsky.tuningcenter.application.service.service;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class EditServiceService {

    private DAO<Service> serviceDAO = new DAOService();

    public boolean editService(Service service, String description, int price, String type, int time) {
        try {
            service.setDescription(description);
            service.setPrice(price);
            service.setType(type);
            service.setTime(time);

            serviceDAO.update(service);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
