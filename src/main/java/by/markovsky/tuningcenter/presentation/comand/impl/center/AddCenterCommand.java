package by.markovsky.tuningcenter.presentation.comand.impl.center;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.AddCenterService;
import by.markovsky.tuningcenter.application.validation.CenterValidator;
import by.markovsky.tuningcenter.domain.entity.tuningservice.Center;
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

        try {
            Center center = (Center) httpSession.getAttribute(AttributeParameters.CENTER);
            if (center != null) {
                throw new RepeatPostException();
            }

            String name = req.getParameter(RequestParameter.NAME);
            String address = req.getParameter(RequestParameter.ADDRESS);
            String telephone = req.getParameter(RequestParameter.TELEPHONE);
            CenterValidator.isCenterFormValid(name, address, telephone);

            addCenterService.addCenter(name, address, Long.parseLong(telephone));

            List<Center> centerList = orderPageDataService.getAllCenters();
            httpSession.setAttribute(AttributeParameters.CENTER_LIST, centerList);
            httpSession.setAttribute(AttributeParameters.CENTER, centerList.get(centerList.size() - 1));
        } catch (ValidationException ve) {
            page += URLQuery.NOT_VALID_CENTER_FORM;
        } catch (RepeatPostException rpe) {
            page += URLQuery.REPEAT_POST;
        }

        router.setRouteType(Router.RouteType.FORWARD);
        router.setPagePath(page);

        return router;
    }

}
