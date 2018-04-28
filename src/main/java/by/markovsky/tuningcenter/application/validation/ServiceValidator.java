package by.markovsky.tuningcenter.application.validation;

import by.markovsky.tuningcenter.infrastructure.constant.RegEx;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.infrastructure.util.RegExValidator;

public class ServiceValidator {

    public static boolean isServiceFormValid(String price, String time) throws ValidationException {
        if (!(RegExValidator.isValid(price, RegEx.SERVICE_PRICE)
                && RegExValidator.isValid(time, RegEx.SERVICE_TIME))) {
            throw new ValidationException();
        }
        return true;
    }

}
