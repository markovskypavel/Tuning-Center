package by.markovsky.tuningcenter.presentation.comand.impl.order;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.order.ConfirmOrderService;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.RepeatPostException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeclineOrderCommand implements Command {

    private ConfirmOrderService confirmOrderService;
    private OrderPageDataService orderPageDataService;

    public DeclineOrderCommand(ConfirmOrderService confirmOrderService, OrderPageDataService orderPageDataService) {
        this.confirmOrderService = confirmOrderService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ADMIN_ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        try {
            Order order = (Order) httpSession.getAttribute(AttributeParameters.ORDER);
            if (order == null) {
                throw new RepeatPostException();
            }

            confirmOrderService.declineOrder(order);

            httpSession.removeAttribute(AttributeParameters.ORDER);
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrders());
        httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
