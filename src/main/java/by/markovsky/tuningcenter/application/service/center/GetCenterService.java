package by.markovsky.tuningcenter.application.service.center;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public class GetCenterService {

    private DAO<Center> centerDAO = new DAOCenter();

    public Center get(int id) {
        Center center = null;
        try {
            center = centerDAO.getById(id);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return center;
    }

}
