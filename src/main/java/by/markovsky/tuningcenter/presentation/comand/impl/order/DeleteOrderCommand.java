package by.markovsky.tuningcenter.presentation.comand.impl.order;

import by.markovsky.tuningcenter.application.service.order.DeleteOrderService;
import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.RepeatPostException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteOrderCommand implements Command {

    private DeleteOrderService deleteOrderService;
    private OrderPageDataService orderPageDataService;

    public DeleteOrderCommand(DeleteOrderService deleteOrderService, OrderPageDataService orderPageDataService) {
        this.deleteOrderService = deleteOrderService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        HttpSession httpSession = req.getSession();
        String page = JspPagePath.MAIN_PAGE;

        User user = (User) httpSession.getAttribute(AttributeParameters.USER);

        try {
            page = user.isStatus()? JspPagePath.ADMIN_ORDER_PAGE : JspPagePath.ORDER_PAGE;

            Order order = (Order) httpSession.getAttribute(AttributeParameters.ORDER);
            if (order == null) {
                throw new RepeatPostException();
            }

            deleteOrderService.deleteOrder(order);

            httpSession.removeAttribute(AttributeParameters.ORDER);
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        if (user.isStatus()) {
            httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrders());
        } else {
            httpSession.setAttribute(AttributeParameters.ORDER_LIST, orderPageDataService.getAllOrdersByLogin(user.getLogin()));
        }
        httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
