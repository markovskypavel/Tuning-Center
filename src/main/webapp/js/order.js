require.config({
    baseUrl: document.getElementById("contextPathHolder").getAttribute('data-contextPath') + "/js",
    paths: {
        "jquery": "libs/jquery",
        "navbar": "modules/navbar",
        "command": "modules/command"
    }
});

require(['navbar', 'command'], function () {

});