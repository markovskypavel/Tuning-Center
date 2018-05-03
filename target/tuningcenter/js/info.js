require.config({
    baseUrl: document.getElementById("contextPathHolder").getAttribute('data-contextPath') + "/js",
    paths: {
        "jquery": "libs/jquery",
        "pictures": "modules/pictures",
        "navbar": "modules/navbar",
        "scrolling": "modules/scrolling"
    }
});

require(['navbar', 'pictures', 'scrolling'], function () {

});