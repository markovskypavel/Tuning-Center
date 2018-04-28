package by.markovsky.tuningcenter.presentation.comand.impl.user;

import by.markovsky.tuningcenter.application.service.user.UserAuthorizationService;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.*;
import by.markovsky.tuningcenter.infrastructure.exception.AuthorizationException;
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
            User user = userAuthorizationService.userAuthorization(login, password);

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute(AttributeParameters.USER, user);
        } catch (AuthorizationException ae) {
            page += URLQuery.NO_AUTHORIZATION;
        }

        router.setRouteType(Router.RouteType.REDIRECT);
        router.setPagePath(page);

        return router;
    }

}
