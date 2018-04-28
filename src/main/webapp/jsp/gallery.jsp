<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1">
    <title>Тюнинг-ателье StanceGarage</title>
    <link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resource/57.ico" type="image/x-icon">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    <script data-main="${pageContext.request.contextPath}/js/gallery"
            src="${pageContext.request.contextPath}/js/libs/require.js"></script>
</head>
<body>
<div id="wrapper">
    <nav>
        <ul class="top-menu">
            <li><a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo" class="logoPic"></a></li>
            <li><a href="${pageContext.request.contextPath}/info">ТЮНИНГ</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/gallery" class="active">ГАЛЛЕРЕЯ</a></li>
            <li><a href="${pageContext.request.contextPath}/about">О НАС</a></li>
            <c:if test="${not empty sessionScope.user}">
                <li>
                    <a href="${pageContext.request.contextPath}" name="orderBtn">ЗАКАЗ</a>
                    <form name="orderForm" action="${pageContext.request.contextPath}/controller" method="POST" style="display:none;">
                        <input type="hidden" name="command" value="GET_ORDER_FORM">
                    </form>
                </li>
            </c:if>
        </ul>
    </nav>

    <section class="gallery">
        <div>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic11.jpg" alt="pic11">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic12.jpg" alt="pic12">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic13.jpg" alt="pic13">
            </figure>
        </div>

        <div>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic21.jpg" alt="pic21">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic22.jpg" alt="pic22">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic23.jpg" alt="pic23">
            </figure>
        </div>

        <div>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic31.jpg" alt="pic31">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic32.jpg" alt="pic32">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic33.jpg" alt="pic33">
            </figure>
        </div>

        <div>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic41.jpg" alt="pic41">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic42.jpg" alt="pic42">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic43.jpg" alt="pic43">
            </figure>
        </div>

        <div>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic51.jpg" alt="pic51">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic52.jpg" alt="pic52">
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/pic53.jpg" alt="pic53">
            </figure>
        </div>
    </section>

    <footer>
        <div id="sitemap">
            <h3>КАРТА САЙТА</h3>
            <div>
                <a href="${pageContext.request.contextPath}/main">ГЛАВНАЯ</a>
                <a href="${pageContext.request.contextPath}/info">ТЮНИНГ</a>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/gallery">ГАЛЛЕРЕЯ</a>
                <a href="${pageContext.request.contextPath}/about">О НАС</a>
            </div>
            <div>
                <c:if test="${not empty sessionScope.user}">
                    <a href="${pageContext.request.contextPath}" name="orderBtn">ЗАКАЗ</a>
                </c:if>
                <a href="https://twitter.com/markovskypavel">ПОДДЕРЖКА</a>
            </div>
        </div>

        <div id="social">
            <h3>СОЦИАЛЬНЫЕ СЕТИ</h3>
            <a href="https://twitter.com/markovskypavel" class="social-icon twitter"></a>
            <a href="https://vk.com/markovskypavel" class="social-icon vk"></a>
            <a href="https://www.youtube.com/channel/UC04fb6s2HDbm1_P_OIdhbPg" class="social-icon youtube"></a>
            <a href="https://www.instagram.com/markovskypavel/" class="social-icon instagram"></a>
        </div>

        <div id="footer-logo">
            <a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo" class="footer-logo"></a>
            <p>Марковский Павел, 572303</p>
        </div>
    </footer>
</div>
</body>
</html>
