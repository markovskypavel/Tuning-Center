package by.markovsky.tuningcenter.presentation.comand.impl;

import by.markovsky.tuningcenter.presentation.comand.Command;
import by.markovsky.tuningcenter.presentation.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class CommandDecorator implements Command {

    protected Command command;

    public CommandDecorator(Command command) {
        this.command = command;
    }

    @Override
    public Router execute(HttpServletRequest req, HttpServletResponse res) {
        return command.execute(req, res);
    }

}
