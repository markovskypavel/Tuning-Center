package by.markovsky.tuningcenter.application.service.center;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class AddCenterService {

    private DAO<Center> centerDAO = new DAOCenter();

    public boolean addCenter(String name, String address, long telephone) {
        try {
            Center center = new Center(name, address, telephone);
            centerDAO.add(center);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
