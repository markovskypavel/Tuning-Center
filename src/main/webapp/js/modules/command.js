define("command", ['jquery'], function ($) {

    /*Изменение команды выбора формы в зависимости от кнопки*/
    $('#getformorder').on('click', function () {
        $('#getform').val("GET_ORDER_FORM");
    });

    $('#getformservice').on('click', function () {
        $('#getform').val("GET_SERVICE_FORM");
    });

    $('#getformcenter').on('click', function () {
        $('#getform').val("GET_CENTER_FORM");
    });

    /*Изменение команды центра в зависимости от кнопки*/
    $('#newcenter').on('click', function () {
        $('#centercommand').val("GET_CENTER_FORM");
    });

    $('#sendcenter').on('click', function () {
        $('#centercommand').val("ADD_CENTER");
    });

    $('#editcenter').on('click', function () {
        $('#centercommand').val("EDIT_CENTER");
    });

    $('#deletecenter').on('click', function () {
        $('#centercommand').val("DELETE_CENTER");
    });

    /*Изменение команды центра в зависимости от кнопки*/
    $('#newservice').on('click', function () {
        $('#servicecommand').val("GET_SERVICE_FORM");
    });

    $('#sendservice').on('click', function () {
        $('#servicecommand').val("ADD_SERVICE");
    });

    $('#editservice').on('click', function () {
        $('#servicecommand').val("EDIT_SERVICE");
    });

    $('#deleteservice').on('click', function () {
        $('#servicecommand').val("DELETE_SERVICE");
    });

    /*Изменение команды заказа в зависимости от кнопки*/
    $('#neworder').on('click', function () {
        $('#ordercommand').val("GET_ORDER_FORM");
    });

    $('#sendorder').on('click', function () {
        $('#ordercommand').val("ADD_ORDER");
    });

    $('#editorder').on('click', function () {
        $('#ordercommand').val("EDIT_ORDER");
    });

    $('#deleteorder').on('click', function () {
        $('#ordercommand').val("DELETE_ORDER");
    });

    $('#approveorder').on('click', function () {
        $('#ordercommand').val("APPROVE_ORDER");
    });

    $('#declineorder').on('click', function () {
        $('#ordercommand').val("DECLINE_ORDER");
    });

});