package by.markovsky.tuningcenter.application.service.center;

import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOCenter;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

public class EditCenterService {

    private DAO<Center> centerDAO = new DAOCenter();

    public boolean editCenter(Center center, String name, String address, long telephone) {
        try {
            center.setName(name);
            center.setAddress(address);
            center.setTelephone(telephone);

            centerDAO.update(center);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
            return false;
        }
        return true;
    }

}
