package by.markovsky.tuningcenter.presentation.comand.impl.service;

import by.markovsky.tuningcenter.application.service.service.AddServiceService;
import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.validation.CenterValidator;
import by.markovsky.tuningcenter.application.validation.ServiceValidator;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServiceCommand implements Command {

    private AddServiceService addServiceService;
    private OrderPageDataService orderPageDataService;

    public AddServiceCommand(AddServiceService addServiceService, OrderPageDataService orderPageDataService) {
        this.addServiceService = addServiceService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ADMIN_ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        String description = req.getParameter(RequestParameter.DESCRIPTION);
        String price = req.getParameter(RequestParameter.PRICE);
        String time = req.getParameter(RequestParameter.TIME);
        String serviceType = req.getParameter(RequestParameter.SERVICE_TYPE);

        try {
            ServiceValidator.isServiceFormValid(price, time);
            addServiceService.addService(description, Integer.parseInt(price), serviceType, Integer.parseInt(time));

            httpSession.removeAttribute(AttributeParameters.SERVICE);
            httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_SERVICE_FORM;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
