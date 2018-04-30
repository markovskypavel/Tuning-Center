package by.markovsky.tuningcenter.application.validation;

import by.markovsky.tuningcenter.infrastructure.constant.RegEx;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.infrastructure.util.RegExValidator;

public class CenterValidator {

    public static boolean isCenterFormValid(String name, String address, String telephone) throws ValidationException {
        if (name == null || address == null || telephone == null) {
            throw new ValidationException();
        }
        if (!(RegExValidator.isValid(name, RegEx.CENTER_NAME)
                && RegExValidator.isValid(address, RegEx.CENTER_ADDRESS)
                && RegExValidator.isValid(telephone, RegEx.TELEPHONE))) {
            throw new ValidationException();
        }
        return true;
    }

}
