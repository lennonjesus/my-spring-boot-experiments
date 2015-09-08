package com.lennonjesus.experiments.authentication.form.validator;

import com.lennonjesus.experiments.authentication.form.UserCreateForm;
import com.lennonjesus.experiments.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Lennon Jesus
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;

        validatePasswords(errors, form);
        validateEmail(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if(!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords não conferem");
        }
    }

    private void validateEmail(Errors errors, UserCreateForm form) {
        if(userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "Já existe um usuário com esse e-mail");
        }
    }
}

