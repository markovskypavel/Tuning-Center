package by.markovsky.tuningcenter.presentation.comand.impl.user;

import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogoutCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        return null;
    }

}
