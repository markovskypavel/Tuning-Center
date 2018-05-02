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
    <script data-main="${pageContext.request.contextPath}/js/order"
            src="${pageContext.request.contextPath}/js/libs/require.js"></script>
</head>
<body>
<div id="wrapper">
    <nav>
        <ul class="top-menu">
            <li><a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo" class="logoPic"></a></li>
            <li><a href="${pageContext.request.contextPath}/info">ТЮНИНГ</a></li>
            <li><a href="${pageContext.request.contextPath}/gallery">ГАЛЛЕРЕЯ</a></li>
            <li><a href="${pageContext.request.contextPath}/about">О НАС</a></li>
            <c:if test="${not empty sessionScope.user}">
                <li class="active">
                    <a href="${pageContext.request.contextPath}" name="orderBtn" class="active">ЗАКАЗ</a>
                    <form name="orderForm" action="${pageContext.request.contextPath}/controller" method="POST" style="display:none;">
                        <input type="hidden" name="command" value="GET_ORDER_FORM">
                    </form>
                </li>
            </c:if>
        </ul>
    </nav>

    <aside>
        <div class='comments'>
            <c:forEach var="item" items="${sessionScope.orderlist}">
                <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                    <input type="hidden" name="command" value="GET_ORDER">
                    <input type="hidden" name="orderid" value="${item.id}">
                    <p>Статус заказа №${item.id}: ${item.status ? "готов" : "не готов"}</p>
                    <input type="submit" value="Открыть">
                </form>
            </c:forEach>
        </div>
    </aside>

    <section class="feedback">
        <form name="Survey" action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" id="ordercommand" name="command" value="ADD_ORDER">

            <p>Введите имя:</p>
            <INPUT type="text" NAME="name" placeholder="Ваше имя" value="${sessionScope.order.automobile.client.name}"
                   pattern="^[А-ЯЁ][а-яё]{0,9}([\-][А-ЯЁ][а-яё]{0,9}){0,1}$" title="Пример: Павел, Анна-Мария" required>

            <p>Введите фамилию:</p>
            <INPUT type="text" NAME="surname" placeholder="Ваша фамилия" value="${sessionScope.order.automobile.client.surname}"
                   pattern="^[А-ЯЁ][а-яё]{0,9}([\-][А-ЯЁ][а-яё]{0,9}){0,1}$" title="Пример: Марковский, Юн-Ян" required>

            <p>Введите номер паспорта:</p>
            <INPUT type="text" NAME="passport" placeholder="Номер паспорта" value="${sessionScope.order.automobile.client.passport}"
                   pattern="^((АВ)|(AB)|(ВМ)|(BM)|(НВ)|(HB)|(КН)|(KH)|(МР)|(MP)|(МС)|(MC)|(КВ)|(KB)|(РР)|(PP))([0-9]{7})$" title="Пример: МР1234567" required>

            <p>Введите номер телефона:</p>
            <INPUT type="text" NAME="telephone" placeholder="Ваш номер" value="${sessionScope.order.automobile.client.telephone}"
                   pattern="^((17)|(29)|(33)|(44)|(25))([1-9][0-9]{6})$" title="Пример: 291234567, 441234567" required>

            <p>Введите модель автомобиля:</p>
            <INPUT type="text" NAME="model" placeholder="Ваш автомобиль" value="${sessionScope.order.automobile.model}"
                   pattern="^([A-Z][a-z]{0,9})([\-][A-Za-z0-9]{1,8}|[\s][A-Za-z0-9]{1,8}){0,1}$" title="Пример: Audi RS6, Volvo XC90, Ваз 2107" required>

            <p>Введите год выпуска автомобиля:</p>
            <INPUT type="text" NAME="year" placeholder="Год выпуска" value="${sessionScope.order.automobile.year}"
                   pattern="^(19|20)\d{2}$" title="Пример: 2015, 1992" required>

            <p>Выберите центр обслуживания:</p>
            <table>
                <c:forEach var="item" items="${sessionScope.centerlist}">
                    <tr><td>
                        <INPUT TYPE="radio" NAME="centerid" VALUE="${item.id}" <c:if test="${sessionScope.order.center.id == item.id}">CHECKED</c:if><c:if test="${empty sessionScope.order}">CHECKED</c:if>>
                        <label>"${item.name}": ${item.address}, тел. +375${item.telephone}</label>
                    </td></tr>
                </c:forEach>
            </table>

            <p>Выберите вид услуги:</p>
            <table>
                <c:forEach var="item" items="${sessionScope.servicelist}">
                    <tr><td>
                        <INPUT TYPE="radio" NAME="serviceid" VALUE="${item.id}" <c:if test="${sessionScope.order.service.id == item.id}">CHECKED</c:if><c:if test="${empty sessionScope.order}">CHECKED</c:if>>
                        <label><u>${item.type}</u>: ${item.description} ( ${item.price}$, ${item.time} нед. )</label>
                    </td></tr>
                </c:forEach>
            </table>

            <INPUT TYPE="submit" id="neworder" VALUE="Новый заказ" formnovalidate>
            <c:if test="${empty sessionScope.order}">
                <input type="submit" id="sendorder" value="Заказ">
            </c:if>
            <c:if test="${not empty sessionScope.order}">
                <input type="submit" id="editorder" value="Редакт.">
                <input type="submit" id="deleteorder" value="Удалить">
            </c:if>
            </br>
            <c:if test="${param.notvalidorder == true}">
                <span class="error">Неправильно заполнены некоторые поля</span>
            </c:if>
            <c:if test="${param.repeatpost == true}">
                <span class="error">Ошибка повторной отправки</span>
            </c:if>
        </form>
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
