package by.markovsky.tuningcenter.application.validation;

import by.markovsky.tuningcenter.infrastructure.constant.RegEx;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.infrastructure.util.RegExValidator;

public class UserValidator {

    public static boolean isRegistrationFormValid(String login, String password, String email) throws ValidationException {
        if (login == null || password == null || email == null) {
            throw new ValidationException();
        }
        if (!(RegExValidator.isValid(login, RegEx.LOGIN)
                && RegExValidator.isValid(password, RegEx.PASSWORD)
                && RegExValidator.isValid(email, RegEx.EMAIL))) {
            throw new ValidationException();
        }
        return true;
    }

    public static boolean isAuthorizationFormValid(String login, String password) throws ValidationException {
        if (login == null || password == null) {
            throw new ValidationException();
        }
        return true;
    }

}
