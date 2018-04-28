package by.markovsky.tuningcenter.application.service.service;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOService;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public class GetServiceService {

    private DAO<Service> serviceDAO = new DAOService();

    public Service get(int id) {
        Service service = null;
        try {
            service = serviceDAO.getById(id);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return service;
    }

}
