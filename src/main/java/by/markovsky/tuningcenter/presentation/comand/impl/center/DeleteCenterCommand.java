package by.markovsky.tuningcenter.presentation.comand.impl.center;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.DeleteCenterService;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
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

public class DeleteCenterCommand implements Command {

    private DeleteCenterService deleteCenterService;
    private OrderPageDataService orderPageDataService;

    public DeleteCenterCommand(DeleteCenterService deleteCenterService, OrderPageDataService orderPageDataService) {
        this.deleteCenterService = deleteCenterService;
        this.orderPageDataService = orderPageDataService;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = new Router();
        String page = JspPagePath.ADMIN_ORDER_PAGE;
        HttpSession httpSession = req.getSession();

        try {
            Center center = (Center) httpSession.getAttribute(AttributeParameters.CENTER);
            if (center == null) {
                throw new RepeatPostException();
            }

            deleteCenterService.deleteCenter(center);

            httpSession.removeAttribute(AttributeParameters.CENTER);
            httpSession.setAttribute(AttributeParameters.CENTER_LIST, orderPageDataService.getAllCenters());
        } catch (ExistOrderException eoe) {
            page += URLQuery.EXIST_CENTER;
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
