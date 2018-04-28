package by.markovsky.tuningcenter.presentation.comand.impl;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RefreshCommand implements Command {

    private OrderPageDataService orderPageDataService;

    public RefreshCommand(OrderPageDataService orderPageDataService) {
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        HttpSession httpSession = req.getSession();
        String page;

        httpSession.removeAttribute(AttributeParameters.ORDER);
        httpSession.removeAttribute(AttributeParameters.CENTER);
        httpSession.removeAttribute(AttributeParameters.SERVICE);
        httpSession.removeAttribute(AttributeParameters.ORDER_FORM);
        httpSession.removeAttribute(AttributeParameters.CENTER_FORM);
        httpSession.removeAttribute(AttributeParameters.SERVICE_FORM);

        User user = (User) httpSession.getAttribute(AttributeParameters.USER);
        if (user.isStatus()) {
            page = JspPagePath.ADMIN_ORDER_PAGE;
            httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrders());
        } else {
            page = JspPagePath.ORDER_PAGE;
            httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrdersByLogin(user.getLogin()));
        }
        httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
