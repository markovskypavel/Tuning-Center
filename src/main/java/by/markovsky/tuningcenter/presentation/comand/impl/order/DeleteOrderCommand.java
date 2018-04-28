package by.markovsky.tuningcenter.presentation.comand.impl.order;

import by.markovsky.tuningcenter.application.service.order.DeleteOrderService;
import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Order;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
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
        String page;

        User user = (User) httpSession.getAttribute(AttributeParameters.USER);
        Order order = (Order) httpSession.getAttribute(AttributeParameters.ORDER);
        httpSession.removeAttribute(AttributeParameters.ORDER);

        deleteOrderService.deleteOrder(order);

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
