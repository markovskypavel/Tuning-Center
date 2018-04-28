package by.markovsky.tuningcenter.presentation.comand.impl.center;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.AddCenterService;
import by.markovsky.tuningcenter.application.service.center.GetCenterService;
import by.markovsky.tuningcenter.domain.entity.user.User;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.RequestParameter;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCenterCommand implements Command {

    private GetCenterService getCenterService;
    private OrderPageDataService orderPageDataService;

    public GetCenterCommand(GetCenterService getCenterService, OrderPageDataService orderPageDataService) {
        this.getCenterService = getCenterService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        HttpSession httpSession = req.getSession();
        String page = JspPagePath.ADMIN_ORDER_PAGE;

        Integer centerid = Integer.valueOf(req.getParameter(RequestParameter.CENTER_ID));
        httpSession.setAttribute(AttributeParameters.CENTER, getCenterService.get(centerid));
        httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
