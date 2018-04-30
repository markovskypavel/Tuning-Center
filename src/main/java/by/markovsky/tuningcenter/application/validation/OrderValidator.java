package by.markovsky.tuningcenter.application.validation;

import by.markovsky.tuningcenter.infrastructure.constant.RegEx;
import by.markovsky.tuningcenter.infrastructure.exception.ValidationException;
import by.markovsky.tuningcenter.infrastructure.util.RegExValidator;

public class OrderValidator {

    public static boolean isOrderFormValid(String name, String surname, String passport, String telephone,
                                           String model, String year, String idCenter, String idService) throws ValidationException {
        if (name == null || surname == null || passport == null || telephone == null
                || model == null || year == null
                || idCenter == null || idService == null) {
            throw new ValidationException();
        }
        if (!(RegExValidator.isValid(name, RegEx.CLIENT_NAME)
                && RegExValidator.isValid(surname, RegEx.CLIENT_SURNAME)
                && RegExValidator.isValid(passport, RegEx.CLIENT_PASSPORT)
                && RegExValidator.isValid(telephone, RegEx.TELEPHONE)
                && RegExValidator.isValid(model, RegEx.MODEL_NAME)
                && RegExValidator.isValid(year, RegEx.YEAR))) {
            throw new ValidationException();
        }
        return true;
    }

}
