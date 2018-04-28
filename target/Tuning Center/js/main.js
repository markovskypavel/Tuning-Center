require.config({
    baseUrl: document.getElementById("contextPathHolder").getAttribute('data-contextPath') + "/js",
    paths: {
        "jquery": "libs/jquery",
        "slider": "modules/slider",
        "navbar": "modules/navbar",
        "articles": "modules/articles"
    }
});

require(['navbar', 'slider', 'articles'], function () {

});