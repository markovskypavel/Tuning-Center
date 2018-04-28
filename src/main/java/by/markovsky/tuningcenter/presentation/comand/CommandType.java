package by.markovsky.tuningcenter.presentation.comand;

import by.markovsky.tuningcenter.application.service.OrderPageDataService;
import by.markovsky.tuningcenter.application.service.center.AddCenterService;
import by.markovsky.tuningcenter.application.service.center.DeleteCenterService;
import by.markovsky.tuningcenter.application.service.center.EditCenterService;
import by.markovsky.tuningcenter.application.service.center.GetCenterService;
import by.markovsky.tuningcenter.application.service.order.*;
import by.markovsky.tuningcenter.application.service.service.AddServiceService;
import by.markovsky.tuningcenter.application.service.service.DeleteServiceService;
import by.markovsky.tuningcenter.application.service.service.EditServiceService;
import by.markovsky.tuningcenter.application.service.service.GetServiceService;
import by.markovsky.tuningcenter.application.service.user.UserAuthorizationService;
import by.markovsky.tuningcenter.application.service.user.UserRegistrationService;
import by.markovsky.tuningcenter.presentation.comand.impl.RefreshCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.center.AddCenterCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.center.DeleteCenterCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.center.EditCenterCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.center.GetCenterCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.order.*;
import by.markovsky.tuningcenter.presentation.comand.impl.pageload.GetCenterFormCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.pageload.GetOrderFormCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.pageload.GetServiceFormCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.service.AddServiceCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.service.DeleteServiceCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.service.EditServiceCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.service.GetServiceCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.user.UserAuthorizationCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.user.UserLogoutCommand;
import by.markovsky.tuningcenter.presentation.comand.impl.user.UserRegistrationCommand;

public enum CommandType {

    USER_AUTHORIZATION(new UserAuthorizationCommand(new UserAuthorizationService())),
    USER_REGISTRATION(new UserRegistrationCommand(new UserRegistrationService())),
    USER_LOGOUT(new UserLogoutCommand()),

    GET_ORDER_FORM(new GetOrderFormCommand(new RefreshCommand(new OrderPageDataService()))),
    GET_SERVICE_FORM(new GetServiceFormCommand(new RefreshCommand(new OrderPageDataService()))),
    GET_CENTER_FORM(new GetCenterFormCommand(new RefreshCommand(new OrderPageDataService()))),

    GET_ORDER(new GetOrderCommand(new GetOrderService(), new OrderPageDataService())),
    ADD_ORDER(new AddOrderCommand(new AddOrderService(), new OrderPageDataService())),
    DELETE_ORDER(new DeleteOrderCommand(new DeleteOrderService(), new OrderPageDataService())),
    EDIT_ORDER(new EditOrderCommand(new EditOrderService(), new OrderPageDataService())),

    GET_CENTER(new GetCenterCommand(new GetCenterService(), new OrderPageDataService())),
    ADD_CENTER(new AddCenterCommand(new AddCenterService(), new OrderPageDataService())),
    DELETE_CENTER(new DeleteCenterCommand(new DeleteCenterService(), new OrderPageDataService())),
    EDIT_CENTER(new EditCenterCommand(new EditCenterService(), new OrderPageDataService())),

    GET_SERVICE(new GetServiceCommand(new GetServiceService(), new OrderPageDataService())),
    ADD_SERVICE(new AddServiceCommand(new AddServiceService(), new OrderPageDataService())),
    DELETE_SERVICE(new DeleteServiceCommand(new DeleteServiceService(), new OrderPageDataService())),
    EDIT_SERVICE(new EditServiceCommand(new EditServiceService(), new OrderPageDataService())),

    APPROVE_ORDER(new ApproveOrderCommand(new ConfirmOrderService(), new OrderPageDataService())),
    DECLINE_ORDER(new DeclineOrderCommand(new ConfirmOrderService(), new OrderPageDataService()));

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

}
