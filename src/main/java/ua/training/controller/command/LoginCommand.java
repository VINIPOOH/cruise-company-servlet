package ua.training.controller.command;

import ua.training.controller.form.UserForm;
import ua.training.controller.form.validation.Validator;
import ua.training.controller.handler.ExceptionHandler;
import ua.training.controller.mapper.RequestFormMapper;
import ua.training.exception.UserNotFoundException;
import ua.training.model.entity.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private final UserService userService;
    private final RequestFormMapper<UserForm> userRequestFormMapper;
    private final Validator<UserForm> userValidator;

    public LoginCommand(UserService userService, RequestFormMapper<UserForm> userRequestFormMapper, Validator<UserForm> userValidator) {
        this.userService = userService;
        this.userRequestFormMapper = userRequestFormMapper;
        this.userValidator = userValidator;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:logout";
        }
        UserForm userForm = userRequestFormMapper.mapToForm(request);
        if (userValidator.validate(userForm)) {
            request.setAttribute("errors", true);
            return "/login.jsp";
        }

        User user;
        try {
            user = userService.findUserByLogin(userForm.getLogin());
        } catch (UserNotFoundException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler(e, "login.jsp");
            return exceptionHandler.handling(request);
        }

        if (CommandUtility.checkUserIsLogged(request, user.getLogin())) {
            return "WEB-INF/error.jsp";
        }

        if (userService.checkInputPassword(userForm.getPassword(), user.getPassword())) {
            CommandUtility.setUserInSession(request, user);
            return "redirect:main";
        }
        request.getSession().setAttribute("exception", true);
        return "/login.jsp";


    }


}