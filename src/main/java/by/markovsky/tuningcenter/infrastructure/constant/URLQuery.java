package by.markovsky.tuningcenter.infrastructure.constant;

public interface URLQuery {
    String NOT_VALID_REGISTRATION = "?notvalidreg=true";
    String NOT_VALID_AUTHORIZATION = "?notvalidauth=true";
    String NO_AUTHORIZATION = "?notauth=true";
    String NO_REGISTRATION = "?notreg=true";

    String NOT_VALID_ORDER_FORM = "?notvalidorder=true";
    String NOT_VALID_CENTER_FORM = "?notvalidcenter=true";
    String NOT_VALID_SERVICE_FORM = "?notvalidservice=true";

    String EXIST_CENTER = "?existcenter=true";
    String EXIST_SERVICE = "?existservice=true";

    String REPEAT_POST = "?repeatpost=true";
}
