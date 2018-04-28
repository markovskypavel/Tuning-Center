package by.markovsky.tuningcenter.infrastructure.constant;

public interface RegEx {
    String LOGIN = "^[A-Za-z][A-Za-z0-9_]{2,19}$";
    String PASSWORD = "^[A-Za-z0-9]{3,20}$";
    String EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    String TELEPHONE = "^((17)|(29)|(33)|(44)|(25))([1-9][0-9]{6})$";

    String MODEL_NAME = "^([A-Z][a-z]{0,9})([\\-][A-Za-z0-9]{1,8}|[\\s][A-Za-z0-9]{1,8}){0,1}$";
    String YEAR = "^(19|20)\\d{2}$";

    String CENTER_NAME = "^([А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1})|([A-Z][a-z]{0,9}([\\-][A-Z][a-z]{0,9}){0,1})$";
    String CENTER_ADDRESS = "^((ул\\.\\s)|(просп\\.\\s)|(пер\\.\\s)|(бульвар\\s))([А-ЯЁ][а-яё]{0,20}([\\-][А-ЯЁ][а-яё]{0,20}){0,1})(\\s)([1-9][0-9]{0,3}(\\-[1-5]){0,1})$";

    String CLIENT_NAME = "^[А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1}$";
    String CLIENT_SURNAME = "^[А-ЯЁ][а-яё]{0,9}([\\-][А-ЯЁ][а-яё]{0,9}){0,1}$";
    String CLIENT_PASSPORT = "^((АВ)|(AB)|(ВМ)|(BM)|(НВ)|(HB)|(КН)|(KH)|(МР)|(MP)|(МС)|(MC)|(КВ)|(KB)|(РР)|(PP))([0-9]{7})$";

    String SERVICE_PRICE = "^[1-9][0-9]{0,5}$";
    String SERVICE_TIME = "^[1-9][0-9]{0,2}$";
}
