package by.markovsky.tuningcenter.presentation.comand.impl.service;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.service.EditServiceService;
import by.markovsky.tuningcenter.application.validation.ServiceValidator;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
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

public class EditServiceCommand implements Command {

    private EditServiceService editServiceService;
    private OrderPageDataService orderPageDataService;

    public EditServiceCommand(EditServiceService editServiceService, OrderPageDataService orderPageDataService) {
        this.editServiceService = editServiceService;
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
        Service service = (Service) httpSession.getAttribute(AttributeParameters.SERVICE);

        try {
            ServiceValidator.isServiceFormValid(price, time);
            editServiceService.editService(service, description, Integer.parseInt(price), serviceType, Integer.parseInt(time));

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
