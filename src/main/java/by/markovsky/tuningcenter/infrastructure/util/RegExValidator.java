package by.markovsky.tuningcenter.infrastructure.util;

import java.util.regex.Pattern;

public class RegExValidator {

    public static boolean isValid(String field, String regEx) {
        return Pattern.matches(regEx, field);
    }

}
