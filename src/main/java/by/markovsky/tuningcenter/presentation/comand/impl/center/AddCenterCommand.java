package by.markovsky.tuningcenter.presentation.comand.impl.center;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.AddCenterService;
import by.markovsky.tuningcenter.application.validation.CenterValidator;
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

public class AddCenterCommand implements Command {

    private AddCenterService addCenterService;
    private OrderPageDataService orderPageDataService;

    public AddCenterCommand(AddCenterService addCenterService, OrderPageDataService orderPageDataService) {
        this.addCenterService = addCenterService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ADMIN_ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        String name = req.getParameter(RequestParameter.NAME);
        String address = req.getParameter(RequestParameter.ADDRESS);
        String telephone = req.getParameter(RequestParameter.TELEPHONE);

        try {
            CenterValidator.isCenterFormValid(name, address, telephone);
            addCenterService.addCenter(name, address, Long.parseLong(telephone));

            httpSession.removeAttribute(AttributeParameters.CENTER);
            httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_CENTER_FORM;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}