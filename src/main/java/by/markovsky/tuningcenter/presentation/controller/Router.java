package by.markovsky.tuningcenter.presentation.controller;

import by.markovsky.tuningcenter.infrastructure.constant.JspPagePath;

public class Router {

    public enum RouteType {
        FORWARD, REDIRECT
    }

    private RouteType routeType = RouteType.FORWARD;
    private String pagePath = JspPagePath.MAIN_PAGE;

    //Setters
    public void setRouteType(RouteType routeType) {
        if (routeType == null){
            this.routeType = RouteType.FORWARD;
        }
        this.routeType = routeType;
    }
    public void setPagePath(String pagePath) {
        if (pagePath == null){
            this.pagePath = JspPagePath.MAIN_PAGE;
        }
        this.pagePath = pagePath;
    }

    //Getters
    public String getPagePath(){
        return  pagePath;
    }
    public RouteType getRouteType() {
        return routeType;
    }

}
