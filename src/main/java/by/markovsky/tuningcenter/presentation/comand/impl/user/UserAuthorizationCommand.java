package by.markovsky.tuningcenter.presentation.comand.impl.user;

import by.markovsky.tuningcenter.application.service.user.UserAuthorizationService;
import by.markovsky.tuningcenter.application.validation.UserValidator;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.AuthorizationException;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthorizationCommand implements Command {

    private UserAuthorizationService userAuthorizationService;

    public UserAuthorizationCommand(UserAuthorizationService userAuthorizationService) {
        this.userAuthorizationService = userAuthorizationService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.MAIN_PAGE;

        String login = req.getParameter(RequestParameter.LOGIN_AUTH);
        String password = req.getParameter(RequestParameter.PASSWORD_AUTH);

        try {
            UserValidator.isAuthorizationFormValid(login, password);
            User user = userAuthorizationService.userAuthorization(login, password);

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute(AttributeParameters.USER, user);
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_AUTHORIZATION;
        } catch (AuthorizationException ae) {
            page += URLQuery.NO_AUTHORIZATION;
        }

        router.setRouteType(Router.RouteType.REDIRECT);
        router.setPagePath(page);

        return router;
    }

}
