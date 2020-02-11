package ua.training.controller.command;

import ua.training.controller.form.UserForm;
import ua.training.controller.form.validation.Validator;
import ua.training.controller.handler.ExceptionHandler;
import ua.training.controller.mapper.MapperFormToEntity;
import ua.training.controller.mapper.RequestFormMapper;
import ua.training.exception.DuplicateDataBaseException;
import ua.training.model.entity.User;
import ua.training.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private final UserService userService;
    private final RequestFormMapper<UserForm> userRequestFormMapper;
    private final Validator<UserForm> userValidator;


    public RegistrationCommand(UserService userService, RequestFormMapper<UserForm> userRequestFormMapper, Validator<UserForm> userValidator) {
        this.userService = userService;
        this.userRequestFormMapper = userRequestFormMapper;
        this.userValidator = userValidator;
    }

    @Override
    public String execute(HttpServletRequest request) {

        UserForm userForm = userRequestFormMapper.mapToForm(request);
        if (userValidator.validate(userForm)) {
            request.setAttribute("errors", true);
            return "/registration.jsp";
        }

        try {
            userService.saveNewUser(getFormEntityMapper().mapToEntity(userForm));
        } catch (DuplicateDataBaseException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler(e, "registration.jsp");
            return exceptionHandler.handling(request);
        }
        request.getSession().setAttribute("success", true);
        return "redirect:login";
    }

    private MapperFormToEntity<User, UserForm> getFormEntityMapper() {
        return form -> User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .build();
    }
}