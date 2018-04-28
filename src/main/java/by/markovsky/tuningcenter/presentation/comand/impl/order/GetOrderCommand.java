package by.markovsky.tuningcenter.presentation.comand.impl.order;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.order.GetOrderService;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetOrderCommand implements Command {

    private GetOrderService getOrderService;
    private OrderPageDataService orderPageDataService;

    public GetOrderCommand(GetOrderService getOrderService, OrderPageDataService orderPageDataService) {
        this.getOrderService = getOrderService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        HttpSession httpSession = req.getSession();
        String page;

        Integer orderid = Integer.valueOf(req.getParameter(RequestParameter.ORDER_ID));
        httpSession.setAttribute(AttributeParameters.ORDER, getOrderService.get(orderid));

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
