package by.markovsky.tuningcenter.application.service.user;

import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOUser;
import by.markovsky.tuningcenter.infrastructure.exception.AuthorizationException;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public class UserAuthorizationService {

    private DAO<User> userDAO = new DAOUser();

    /*Сервис авторизации пользователя*/
    public User userAuthorization(String login, String password) throws AuthorizationException {
        List<User> userList = null;
        User authorizedUser = null;

        String query = "select u from Users u where u.login='" + login + "' and u.password='" + password + "'";
        try {
            userList = userDAO.getByQuery(query);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        /*Проверка существует ли пользователь*/
        for (User user : userList) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                authorizedUser = user;
                break;
            }
        }

        if(authorizedUser == null){
            throw new AuthorizationException();
        }

        return authorizedUser;
    }

}
