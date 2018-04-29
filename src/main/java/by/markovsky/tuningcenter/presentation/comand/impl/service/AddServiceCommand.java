package by.markovsky.tuningcenter.presentation.comand.impl.service;

import by.markovsky.tuningcenter.application.service.service.AddServiceService;
import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.validation.CenterValidator;
import by.markovsky.tuningcenter.application.validation.ServiceValidator;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.RepeatPostException;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

        try {
            Service service = (Service) httpSession.getAttribute(AttributeParameters.SERVICE);
            if (service != null) {
                throw new RepeatPostException();
            }

            String description = req.getParameter(RequestParameter.DESCRIPTION);
            String price = req.getParameter(RequestParameter.PRICE);
            String time = req.getParameter(RequestParameter.TIME);
            String serviceType = req.getParameter(RequestParameter.SERVICE_TYPE);
            ServiceValidator.isServiceFormValid(price, time);

            addServiceService.addService(description, Integer.parseInt(price), serviceType, Integer.parseInt(time));

            List<Service> serviceList = orderPageDataService.getAllServices();
            httpSession.setAttribute(AttributeParameters.SERVICE, serviceList.get(serviceList.size() - 1));
            httpSession.setAttribute(AttributeParameters.SERVICE_LIST, serviceList);
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_SERVICE_FORM;
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
