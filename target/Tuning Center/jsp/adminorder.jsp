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

    <form class="switcher" action="${pageContext.request.contextPath}/controller" method="post">
        <input type="hidden" id="getform" name="command" value="GET_ORDER_FORM">
        <input type="submit" id="getformorder" value="Заказ" <c:if test="${not empty sessionScope.orderform}">class="activebutton"</c:if>>
        <input type="submit" id="getformservice" value="Сервис" <c:if test="${not empty sessionScope.serviceform}">class="activebutton"</c:if>>
        <input type="submit" id="getformcenter" value="Центр" <c:if test="${not empty sessionScope.centerform}">class="activebutton"</c:if>>
    </form>

    <%--ЗАКАЗ--%>
    <c:if test="${not empty sessionScope.orderform}">
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
                <input type="hidden" id="ordercommand" name="command" value="APPROVE_ORDER">

                <p>Имя заказчика:</p>
                <INPUT type="text" NAME="name" placeholder="Имя" value="${sessionScope.order.automobile.client.name}" disabled>

                <p>Фамилия заказчика:</p>
                <INPUT type="text" NAME="surname" placeholder="Фамилия" value="${sessionScope.order.automobile.client.surname}" disabled>

                <p>Номер паспорта заказчика:</p>
                <INPUT type="text" NAME="passport" placeholder="Номер паспорта" value="${sessionScope.order.automobile.client.passport}" disabled>

                <p>Номер телефона заказчика:</p>
                <INPUT type="text" NAME="telephone" placeholder="Номер" value="${sessionScope.order.automobile.client.telephone}" disabled>

                <p>Модель автомобиля:</p>
                <INPUT type="text" NAME="model" placeholder="Автомобиль" value="${sessionScope.order.automobile.model}" disabled>

                <p>Год выпуска автомобиля:</p>
                <INPUT type="text" NAME="year" placeholder="Год выпуска" value="${sessionScope.order.automobile.year}" disabled>

                <p>Центр обслуживания:</p>
                <table>
                    <c:forEach var="item" items="${sessionScope.centerlist}">
                        <tr><td>
                            <INPUT TYPE="radio" NAME="centerid" VALUE="${item.id}"
                                   <c:if test="${sessionScope.order.center.id == item.id}">CHECKED</c:if>
                                   <c:if test="${sessionScope.order.center.id != item.id}">disabled</c:if>>
                            <label>"${item.name}": ${item.address}, тел. +375${item.telephone}</label>
                        </td></tr>
                    </c:forEach>
                </table>

                <p>Вид услуги:</p>
                <table>
                    <c:forEach var="item" items="${sessionScope.servicelist}">
                        <tr><td>
                            <INPUT TYPE="radio" NAME="serviceid" VALUE="${item.id}"
                                   <c:if test="${sessionScope.order.service.id == item.id}">CHECKED</c:if>
                                   <c:if test="${sessionScope.order.service.id != item.id}">disabled</c:if>>
                            <label><u>${item.type}</u>: ${item.description} ( ${item.price}$, ${item.time} недель )</label>
                        </td></tr>
                    </c:forEach>
                </table>

                <c:if test="${not empty sessionScope.order}">
                    <input type="submit" id="approveorder" value="Подтверд.">
                    <input type="submit" id="declineorder" value="Отменить">
                    <input type="submit" id="deleteorder" value="Удалить">
                </c:if>
                <c:if test="${param.repeatpost == true}">
                    <span class="error">Ошибка повторной отправки</span>
                </c:if>
            </form>
        </section>
    </c:if>

    <%--ЦЕНТР--%>
    <c:if test="${not empty sessionScope.centerform}">
        <aside>
            <div class='comments'>
                <c:forEach var="item" items="${sessionScope.centerlist}">
                    <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                        <input type="hidden" name="command" value="GET_CENTER">
                        <input type="hidden" name="centerid" value="${item.id}">
                        <p>Центр №${item.id}: "${item.name}"</p>
                        <input type="submit" value="Открыть">
                    </form>
                </c:forEach>
            </div>
        </aside>
        <section class="feedback">
            <form name="Survey" action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" id="centercommand" name="command" value="ADD_CENTER">

                <p>Введите название центра:</p>
                <INPUT type="text" NAME="name" placeholder="Название центра" value="${sessionScope.center.name}"
                       pattern="^([А-ЯЁ][а-яё]{0,9}([\-][А-ЯЁ][а-яё]{0,9}){0,1})|([A-Z][a-z]{0,9}([\-][A-Z][a-z]{0,9}){0,1})$" title="Пример: Пилот, Авто-Мастер" required>

                <p>Введите номер телефона:</p>
                <INPUT type="text" NAME="telephone" placeholder="Номер телефона" value="${sessionScope.center.telephone}"
                       pattern="^((17)|(29)|(33)|(44)|(25))([1-9][0-9]{6})$" title="Пример: 291234567, 441234567" required>

                <p>Введите адрес центра:</p>
                <INPUT type="text" NAME="address" placeholder="Адрес центра" value="${sessionScope.center.address}"
                       pattern="^((ул\.\s)|(просп\.\s)|(пер\.\s)|(бульвар\s))([А-ЯЁ][а-яё]{0,20}([\-][А-ЯЁ][а-яё]{0,20}){0,1})(\s)([1-9][0-9]{0,3}(\-[1-5]){0,1})$" title="Пример: ул. Воронянского 27" required>
                </br>

                <INPUT TYPE="submit" id="newcenter" VALUE="Новый центр" formnovalidate>
                <c:if test="${empty sessionScope.center}">
                    <input type="submit" id="sendcenter" value="Добавить">
                </c:if>
                <c:if test="${not empty sessionScope.center}">
                    <input type="submit" id="editcenter" value="Редакт.">
                    <input type="submit" id="deletecenter" value="Удалить">
                </c:if>
                </br>
                <c:if test="${param.notvalidcenter == true}">
                    <span class="error">Неправильно заполнены некоторые поля</span>
                </c:if>
                <c:if test="${param.existcenter == true}">
                    <span class="error">Центр уже существует в заказе</span>
                </c:if>
                <c:if test="${param.repeatpost == true}">
                    <span class="error">Ошибка повторной отправки</span>
                </c:if>
            </form>
        </section>
    </c:if>

    <%--СЕРВИС--%>
    <c:if test="${not empty sessionScope.serviceform}">
        <aside>
            <div class='comments'>
                <c:forEach var="item" items="${sessionScope.servicelist}">
                    <form action="${pageContext.request.contextPath}/controller" method="post" align="left">
                        <input type="hidden" name="command" value="GET_SERVICE">
                        <input type="hidden" name="serviceid" value="${item.id}">
                        <p>Сервис №${item.id}: "${item.description}"</p>
                        <input type="submit" value="Открыть">
                    </form>
                </c:forEach>
            </div>
        </aside>
        <section class="feedback">
            <form name="Survey" action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" id="servicecommand" name="command" value="ADD_SERVICE">

                <p>Введите описание услуги:</p>
                <INPUT type="text" NAME="description" placeholder="Описание" value="${sessionScope.service.description}" required>

                <p>Введите цену услуги:</p>
                <INPUT type="text" NAME="price" placeholder="Цена (доллары)" value="${sessionScope.service.price}"
                       pattern="^[1-9][0-9]{0,5}$" title="Пример: 1200, 2500" required>

                <p>Введите время исполнения:</p>
                <INPUT type="text" NAME="time" placeholder="Время (недели)" value="${sessionScope.service.time}"
                       pattern="^[1-9][0-9]{0,2}$" title="Пример: 12, 120" required>

                <p>Выберите тип услуги:</p>
                <table>
                    <tr><td><INPUT TYPE="radio" NAME="servicetype" VALUE="Технический" <c:if test="${sessionScope.service.type == 'Технический'}">CHECKED</c:if> CHECKED><label>Технический</label></td></tr>
                    <tr><td><INPUT TYPE="radio" NAME="servicetype" VALUE="Экстерьер" <c:if test="${sessionScope.service.type == 'Экстерьер'}">CHECKED</c:if>><label>Экстерьер</label></td></tr>
                    <tr><td><INPUT TYPE="radio" NAME="servicetype" VALUE="Интерьер" <c:if test="${sessionScope.service.type == 'Интерьер'}">CHECKED</c:if>><label>Интерьер</label></td></tr>
                </table>

                <INPUT TYPE="submit" id="newservice" VALUE="Новая услуга" formnovalidate>
                <c:if test="${empty sessionScope.service}">
                    <input type="submit" id="sendservice" value="Добавить">
                </c:if>
                <c:if test="${not empty sessionScope.service}">
                    <input type="submit" id="editservice" value="Редакт.">
                    <input type="submit" id="deleteservice" value="Удалить">
                </c:if>
                </br>
                <c:if test="${param.notvalidservice == true}">
                    <span class="error">Неправильно заполнены некоторые поля</span>
                </c:if>
                <c:if test="${param.existservice == true}">
                    <span class="error">Услуга уже существует в заказе</span>
                </c:if>
                <c:if test="${param.repeatpost == true}">
                    <span class="error">Ошибка повторной отправки</span>
                </c:if>
            </form>
        </section>
    </c:if>

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
