package by.markovsky.tuningcenter.application.service.user;

import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.UserStatus;
import by.markovsky.tuningcenter.infrastructure.dao.DAO;
import by.markovsky.tuningcenter.infrastructure.dao.impl.DAOUser;
import by.markovsky.tuningcenter.infrastructure.exception.DAOException;
import by.markovsky.tuningcenter.infrastructure.exception.RegistrationException;

import java.util.List;

public class UserRegistrationService {

    private DAO<User> userDAO = new DAOUser();

    public User userRegistration(String login, String password, String email) throws RegistrationException {
        User user = isUserExists(login, password, email);
        if (user == null) {
            throw new RegistrationException();
        }
        try {
            userDAO.add(user);
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }
        return user;
    }

    /*Проверка пользователя*/
    private User isUserExists(String login, String password, String email) {
        List<User> userList = null;
        try {
            userList = userDAO.getAll();
        } catch (DAOException daoe) {
            daoe.printStackTrace();
        }

        /*Если пользователей нет, то админ*/
        if (userList.isEmpty()) {
            return new User(login, password, email, UserStatus.ADMIN);
        }

        /*Проверка на совпадение логинов или эл. почты*/
        for (User user : userList) {
            if (user.getLogin().equals(login) || user.getEmail().equals(email)) {
                return null;
            }
        }

        return new User(login, password, email, UserStatus.USER);
    }

}
