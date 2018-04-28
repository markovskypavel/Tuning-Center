package by.markovsky.tuningcenter.presentation.comand.impl.service;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.GetCenterService;
import by.markovsky.tuningcenter.application.service.service.GetServiceService;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetServiceCommand implements Command {

    private GetServiceService getServiceService;
    private OrderPageDataService orderPageDataService;

    public GetServiceCommand(GetServiceService getServiceService, OrderPageDataService orderPageDataService) {
        this.getServiceService = getServiceService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        HttpSession httpSession = req.getSession();
        String page = JspPagePath.ADMIN_ORDER_PAGE;

        Integer serviceid = Integer.valueOf(req.getParameter(RequestParameter.SERVICE_ID));
        httpSession.setAttribute(AttributeParameters.SERVICE, getServiceService.get(serviceid));
        httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
