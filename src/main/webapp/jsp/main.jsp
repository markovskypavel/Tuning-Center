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
    <script data-main="${pageContext.request.contextPath}/js/main"
            src="${pageContext.request.contextPath}/js/libs/require.js"></script>
</head>
<body>
<div id="wrapper">
    <nav>
        <ul class="top-menu">
            <li><a href="${pageContext.request.contextPath}"><img
                    src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo"
                    class="logoPic"></a></li>
            <li><a href="${pageContext.request.contextPath}/info">ТЮНИНГ</a></li>
            <li><a href="${pageContext.request.contextPath}/gallery">ГАЛЛЕРЕЯ</a></li>
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

    <div id="viewport">
        <ul id="slidewrapper">
            <li class="slide"><img src="${pageContext.request.contextPath}/resource/pic1.jpg" alt="1" class="slide-img">
            </li>
            <li class="slide"><img src="${pageContext.request.contextPath}/resource/pic2.jpg" alt="2" class="slide-img">
            </li>
            <li class="slide"><img src="${pageContext.request.contextPath}/resource/pic3.jpg" alt="3" class="slide-img">
            </li>
            <li class="slide"><img src="${pageContext.request.contextPath}/resource/pic4.jpg" alt="4" class="slide-img">
            </li>
        </ul>
        <ul id="nav-btns">
            <li class="slide-nav-btn"></li>
            <li class="slide-nav-btn"></li>
            <li class="slide-nav-btn"></li>
            <li class="slide-nav-btn"></li>
        </ul>
    </div>

    <aside>
        <nav>
            <ul class="aside-menu">
                <li class="active"><a id="tuning" class="active">Общие сведения</a></li>
                <li><a id="technique">Технический тюнинг</a></li>
                <li><a id="exterior">Внешний тюнинг</a></li>
                <li><a id="interior">Внутренний тюнинг</a></li>
                <li><a id="address">Контакты</a></li>
            </ul>
        </nav>
        <c:if test="${not empty sessionScope.user}">
            <div class="authorized">
                <h2>Welcome, ${sessionScope.user.login}!</h2>
                <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                    <input type="hidden" name="command" value="USER_LOGOUT">
                    <input type="submit" value="Выход" name="logoff">
                </form>
            </div>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <div class="auth">
                <h2>Авторизация</h2>
                <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                    <input type="hidden" name="command" value="USER_AUTHORIZATION">
                    <input type="text" name="loginAuth" placeholder="логин" required></br>
                    <input type="password" name="passwordAuth" placeholder="пароль" required>
                    <input type="submit" value="Войти">
                    <c:if test="${param.notauth == true}">
                        <span class="error">Неправильный логин или пароль</span>
                    </c:if>
                    <c:if test="${param.notvalidauth == true}">
                        <span class="error">Некорректное заполнение формы</span>
                    </c:if>
                </form>
            </div>
            <div class="reg">
                <h2>Регистрация</h2>
                <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                    <input type="hidden" name="command" value="USER_REGISTRATION">
                    <input type="email" name="emailReg" placeholder="эл.адрес" required></br>
                    <input type="text" name="loginReg" placeholder="логин"
                           pattern="[A-Za-z][A-Za-z0-9_]{2,19}$" title="Пример: maRkovsky123" required></br>
                    <input type="password" name="passwordReg" placeholder="пароль"
                           pattern="^[A-Za-z0-9]{3,20}$" title="Пример: Qwerty123" required>
                    <input type="submit" value="Регистрация">
                    <c:if test="${param.notreg == true}">
                        <span class="error">Пользователь уже существует</span>
                    </c:if>
                    <c:if test="${param.notvalidreg == true}">
                        <span class="error">Некорректное заполнение формы</span>
                    </c:if>
                </form>
            </div>
        </c:if>
    </aside>

    <section>
        <blockquote>
            <p>Машина – не человек. К ней нужно относиться с любовью.</p>
            <cite>Вальтер Рёрль</cite>
        </blockquote>
        <div class="article">
            <p><u>Тюнинг</u> — это настройка конкретной машины под запросы конкретного человека. Тюнинг приобрел в наши
                дни небывалую популярность. Слово «тюнинг» означает настройку или доводку автомобиля. Чем же стандартный
                автомобиль не устраивает своих владельцев, для чего они оборудуют и меняют, делают и переделывают,
                тратят уйму времени и денег?</p>
            <p>Во-первых, тюнинг позволяет выделить автомобиль из общей массы таких же, сделать его более
                комфортабельным и индивидуальным. Кому-то для этого достаточно поставить крутые диски, а кому-то –
                непременно нужна аэрография или огромные спойлеры.</p>
            <p>Во-вторых, стандартный автомобиль в заводском исполнении – нечто компромиссное, в нем динамика принесена
                в жертву максимальной скорости, управляемость – в жертву комфортности, крутящий момент, максимальные
                обороты и мощность двигателя ограничены по соображениям топливной экономичности и так далее. Тюнинг же
                позволяет добиться от автомобиля именно того, что нужно конкретному водителю. Одному достаточно первым
                уходить со светофора, другому нужна управляемость на спортивном уровне, а кому-то – все сразу, да еще и
                дополнительно лошадей 50 под капотом.</p>
        </div>

        <h2>Наши партнёры</h2>

        <div class="team-row">
            <figure>
                <img src="${pageContext.request.contextPath}/resource/11.jpg" alt="11">
                <figcaption><a href="http://www.greddy.com/products/aerodynamics/rocketbunny">Rocket Bunny</a><span>Japan</span>
                </figcaption>
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/12.jpg" alt="12">
                <figcaption><a href="http://www.mansory.com/en">Mansory</a><span>Germany</span></figcaption>
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/13.jpg" alt="13">
                <figcaption><a href="https://vossenrussia.com/">Vossen</a><span>USA</span></figcaption>
            </figure>
        </div>

        <div class="team-row">
            <figure>
                <img src="${pageContext.request.contextPath}/resource/21.jpg" alt="21">
                <figcaption><a href="http://www.brabus.com/en/startpage.php">Brabus</a><span>Germany</span></figcaption>
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/22.jpg" alt="22">
                <figcaption><a href="https://www.work-wheels.co.jp/en/">WORK Wheels</a><span>Japan</span></figcaption>
            </figure>
            <figure>
                <img src="${pageContext.request.contextPath}/resource/23.jpg" alt="23">
                <figcaption><a href="http://www.veilsidejpn.com/en/">VeilSide</a><span>Japan</span></figcaption>
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
            <a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo"
                             class="footer-logo"></a>
            <p>Марковский Павел, 572303</p>
        </div>
    </footer>
    <%--<c:import url="RELATIVE_TO_JSP_PATH"/>--%>
</div>
</body>
</html>
