package by.markovsky.tuningcenter.presentation.comand.impl.service;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.service.DeleteServiceService;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Service;
import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;
import by.markovsky.tuningcenter.infrastructure.constant.URLQuery;
import by.markovsky.tuningcenter.infrastructure.exception.ExistOrderException;
import by.markovsky.tuningcenter.infrastructure.exception.RepeatPostException;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteServiceCommand implements Command {

    private DeleteServiceService deleteServiceService;
    private OrderPageDataService orderPageDataService;

    public DeleteServiceCommand(DeleteServiceService deleteServiceService, OrderPageDataService orderPageDataService) {
        this.deleteServiceService = deleteServiceService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ADMIN_ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        try {
            Service service = (Service) httpSession.getAttribute(AttributeParameters.SERVICE);
            if (service == null) {
                throw new RepeatPostException();
            }

            deleteServiceService.deleteService(service);

            httpSession.removeAttribute(AttributeParameters.SERVICE);
            httpSession.setAttribute(AttributeParameters.SERVICE_LIST, orderPageDataService.getAllServices());
        } catch (ExistOrderException eoe) {
            page += URLQuery.EXIST_SERVICE;
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
