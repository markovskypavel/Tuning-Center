package by.markovsky.tuningcenter.presentation.comand.impl.user;

import by.markovsky.tuningcenter.application.service.user.UserRegistrationService;
import by.markovsky.tuningcenter.application.validation.UserValidator;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.*;
import by.markovsky.tuningcenter.infrastructure.exception.RegistrationException;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserRegistrationCommand implements Command {

    private UserRegistrationService userRegistrationService;

    public UserRegistrationCommand(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.MAIN_PAGE;

        String login = req.getParameter(RequestParameter.LOGIN_REG);
        String password = req.getParameter(RequestParameter.PASSWORD_REG);
        String email = req.getParameter(RequestParameter.EMAIL_REG);

        try {
            UserValidator.isRegistrationFormValid(login, password, email);
            User user = userRegistrationService.userRegistration(login, password, email);

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute(AttributeParameters.USER, user);
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_REGISTRATION;
        } catch (RegistrationException re) {
            page += URLQuery.NO_REGISTRATION;
        }

        router.setRouteType(Router.RouteType.REDIRECT);
        router.setPagePath(page);

        return router;
    }

}
