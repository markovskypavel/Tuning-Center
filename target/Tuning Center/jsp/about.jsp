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
    <script data-main="${pageContext.request.contextPath}/js/about"
            src="${pageContext.request.contextPath}/js/libs/require.js"></script>
</head>
<body>
<div id="wrapper">
    <nav>
        <ul class="top-menu">
            <li><a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo" class="logoPic"></a></li>
            <li><a href="${pageContext.request.contextPath}/info">ТЮНИНГ</a></li>
            <li><a href="${pageContext.request.contextPath}/gallery">ГАЛЛЕРЕЯ</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/about" class="active">О НАС</a></li>
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

    <aside class="founder">
        <h2>Основатель</h2>
        <figure>
            <img src="${pageContext.request.contextPath}/resource/founder.jpg" alt="founder">
            <figcaption><a target="_blank" href="https://vk.com/markovskypavel">Марковский Павел Викторович</a><span>основатель StanceGarage, aka. Clams</span></figcaption>
        </figure>
    </aside>

    <section class="about">
        <p>Марковский Павел Викторович родился 28 июля 1998 года в Минске. С отличием закончил школу и на данный момент обучается на 3 курсе в БГУИР, учится на программиста.</p>
        <p>Павел с детства имел множество увлечений и занятий. На данный момент увлекается видеомонтажом и кино- и мультфильм индустрией и экстремальными видами спорта, такими как сноубординг и скейтбординг. Ещё с детства был помешан на автомобилях, запоминал все автомобильные характеристики с автомобильных журналов.</p>
        <p>Данный сайт создан основателем в 2018 году как сервис по тюнингу автомобилей в различных направлениях. Наши высококвалифицированные специалисты качественно реализуют любую Вашу идею, а также помогут разработать уникальный дизайн для Вашего автомобиля.</p>
        <p>Наша компания, StanceGarage, сотрудничает с множеством производителей деталей для высококачественного тюнинга. Мы имеем в арсенале связи с такими компаниями, как Vossen, Work Wheels, VeilSide и другими.</p>
        <p>Мы ценим каждого клиента и готовы сделать всё, чтобы реализовать Вашу идею максимально качественно для нашего дальнейшего сотрудничества!</p>
        <p>Ждём Ваших заявок в StanceGarage, будем творить ВМЕСТЕ :)</p>
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
