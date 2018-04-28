define("navbar", ['jquery'], function ($) {

    /*Появление ссылок заказа*/
    $('[name=orderBtn]').click(function (e) {
        $('[name=orderForm]').submit();
        e.preventDefault();
    });

    /* Hover для верхнего меню без изменения логотипа */
    $('ul.top-menu').find('li').filter(':nth-child(n+2)').on({
        mouseover: function () {
            $(this).css("background", "#F7CD44");
            $(this).children(':first').css("color", "rgba(36, 36, 36, 1)");
        },
        mouseout: function () {
            $(this).css("background", "");
            $(this).children(':first').css("color", "");
        }
    });

});