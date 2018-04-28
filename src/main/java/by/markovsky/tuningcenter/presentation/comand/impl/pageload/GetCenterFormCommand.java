package by.markovsky.tuningcenter.presentation.comand.impl.pageload;

import by.markovsky.tuningcenter.infrastructure.constant.AttributeParameters;
import by.markovsky.tuningcenter.infrastructure.constant.UtilConstant;
import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.comand.impl.CommandDecorator;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCenterFormCommand extends CommandDecorator {

    public GetCenterFormCommand(Command refreshCommand) {
        super(refreshCommand);
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        Router router = command.execute(req, res);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute(AttributeParameters.CENTER_FORM, UtilConstant.STUB);
        return router;
    }

}
