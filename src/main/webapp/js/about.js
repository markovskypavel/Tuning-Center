require.config({
    baseUrl: document.getElementById("contextPathHolder").getAttribute('data-contextPath') + "/js",
    paths: {
        "jquery": "libs/jquery",
        "navbar": "modules/navbar"
    }
});

require(['navbar'], function () {

});