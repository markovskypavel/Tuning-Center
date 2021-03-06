package by.markovsky.tuningcenter.presentation.comand.impl.order;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.order.EditOrderService;
import by.markovsky.tuningcenter.application.validation.OrderValidator;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.domain.entity.user.User;
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

public class EditOrderCommand implements Command {

    private EditOrderService editOrderService;
    private OrderPageDataService orderPageDataService;

    public EditOrderCommand(EditOrderService editOrderService, OrderPageDataService orderPageDataService) {
        this.editOrderService = editOrderService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        User user = (User) httpSession.getAttribute(AttributeParameters.USER);

        try {
            Order order = (Order) httpSession.getAttribute(AttributeParameters.ORDER);
            if (order == null) {
                throw new RepeatPostException();
            }

            String name = req.getParameter(RequestParameter.NAME);
            String surname = req.getParameter(RequestParameter.SURNAME);
            String passport = req.getParameter(RequestParameter.PASSPORT);
            String telephone = req.getParameter(RequestParameter.TELEPHONE);
            String model = req.getParameter(RequestParameter.MODEL);
            String year = req.getParameter(RequestParameter.YEAR);
            String idCenter = req.getParameter(RequestParameter.CENTER_ID);
            String idService = req.getParameter(RequestParameter.SERVICE_ID);
            OrderValidator.isOrderFormValid(name, surname, passport, telephone, model, year, idCenter, idService);

            editOrderService.editOrder(order, name, surname, passport, Long.parseLong(telephone),
                    model, Integer.parseInt(year),
                    Integer.parseInt(idCenter), Integer.parseInt(idService));

            httpSession.removeAttribute(AttributeParameters.ORDER);
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_ORDER_FORM;
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrdersByLogin(user.getLogin()));
        httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
