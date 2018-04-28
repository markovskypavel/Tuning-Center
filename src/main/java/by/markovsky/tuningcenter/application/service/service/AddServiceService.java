package by.markovsky.tuningcenter.application.service.service;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class AddServiceService {

    private DAO<Service> serviceDAO = new DAOService();

    public boolean addService(String description, int price, String type, int time) {
        try {
            Service service = new Service(description, price, type, time);
            serviceDAO.add(service);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
