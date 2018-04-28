package by.markovsky.tuningcenter.presentation.comand;

import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Router execute(HttpServletRequest req, HttpServletResponse res);
}
