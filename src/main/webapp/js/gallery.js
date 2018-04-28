require.config({
    baseUrl: document.getElementById("contextPathHolder").getAttribute('data-contextPath') + "/js",
    paths: {
        "jquery": "libs/jquery",
        "pictures": "modules/pictures",
        "navbar": "modules/navbar"
    }
});

require(['navbar', 'pictures'], function () {

});