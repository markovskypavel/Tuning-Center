package by.markovsky.tuningcenter.presentation.comand.impl;

import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmptyCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        return null;
    }

}
