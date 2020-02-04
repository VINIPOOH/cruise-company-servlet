package ua.training.controller.command;

import ua.training.controller.command.handler.ExceptionHandler;
import ua.training.exception.UserNotFoundException;
import ua.training.model.entity.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //todo clean Session
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:logout";
        }

        String login = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (login == null || login.equals("") || pass == null || pass.equals("")) {
            return "/login.jsp";
        }

        // Выкинет ошибку если не существует пользователя в базе (не правильный логин)
        User user;
        try {
            user = userService.findUserByLogin(login);
        } catch (UserNotFoundException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler(e, "login.jsp");
            return exceptionHandler.handling(request);
        }

        if (CommandUtility.checkUserIsLogged(request, login)) {
            return "WEB-INF/error.jsp";
        }

        if (userService.checkInputPassword(pass, user.getPassword())) {
            CommandUtility.setUserInSession(request, user, login);
            return "redirect:main";
        } else {
            request.getSession().setAttribute("exception", true);
            return "/login.jsp";
        }


    }



}
