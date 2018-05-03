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
    <script data-main="${pageContext.request.contextPath}/js/info"
            src="${pageContext.request.contextPath}/js/libs/require.js"></script>
</head>
<body>
<div id="wrapper">
    <nav>
        <ul class="top-menu">
            <li><a href="${pageContext.request.contextPath}/main"><img src="${pageContext.request.contextPath}/resource/logo.png" alt="SiteLogo" class="logoPic"></a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/info" class="active">ТЮНИНГ</a></li>
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

    <aside>
        <nav class="news-aside">
            <ul class="aside-menu">
                <li><a href="#Stance">STANCE</a></li>
                <li><a href="#Drift">DRIFT</a></li>
                <li><a href="#Dtm">DTM</a></li>
                <li><a href="#Dragster">DRAGSTER</a></li>
                <li><a href="#Bosozoku">BOSOZOKU</a></li>
            </ul>
        </nav>
    </aside>

    <section>
        <div class="news" id="Stance">
            <h2><u>STANCE</u>: ЕЗДИМ НИЗКО</h2>
            <p>Stance - это вся культура низких машин.</p>
            <p>Stance (в переводе с англ. "посадка") — все чаще применяется к автомобилям относительно клиренса (дорожного просвета) и заменяет слово Drop (в переводе с англ. "падение"), которым обозначается заниженный и уроненный на самое брюхо автомобиль (дропнутый).</p>
            <p>К ней относятся VW, ВАЗ, Opel, BMW и все остальные марки и модели автомобилей, выдержанные в общих традициях- правильные диски и посадка, а также наличие изюминки, позволяющей автомобилю отличаться от себе подобных (например, редкие OEM-фары от Golf MK2 Rallye на Jetta MK2 и т.д.). Так что неважно, Daewoo Lanos это или же Audi A6. Главное то, чтобы машины были стильными!</p>
            <div class="news-pictures">
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news11.jpg" title="DC Team" alt="news11">
                </figure>
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news12.jpg" title="Map of tour" alt="news12">
                </figure>
            </div>
        </div>
        <div class="news" id="Drift">
            <h2><u>DRIFT</u>: БОКОМ С РОЖДЕНИЯ</h2>
            <p>В автомобиле для дрифта особое внимание уделяется равномерному распределению крутящего момента по оборотам. Автомобили облегчаются и подвергаются тюнингу, в частности форсируется двигатель, заваривается задний дифференциал или ставится блокировка LSD (limited slip differential).</p>
            <p>Классическими автомобилями для дрифта являются: Nissan 240 SX, Nissan Silvia, Nissan 180SX, Nissan Skyline, Nissan Laurel, Mazda RX-7(Mazda RX-8), Toyota Supra, Toyota Alteza, Toyota Chaser(все "Mark" образные) и Toyota AE86, а также её наследница Toyota GT86.</p>
            <p>В основном предпочтение отдаётся автомобилям с приводом на задние колеса, но существуют примеры, когда машину под дрифт готовят изначально полноприводной (Subaru Impreza, Mitsubishi Lancer Evolution, Nissan Skyline GT-R), избавляя от системы привода передних колес.</p>
            <div class="news-pictures">
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news21.jpg" title="Heli in mountains" alt="news21">
                </figure>
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news22.jpg" title="Mountains" alt="news22">
                </figure>
            </div>
        </div>
        <div class="news" id="Dtm">
            <h2><u>DTM</u>: ГОНОЧНАЯ АГРЕССИЯ</h2>
            <p>Deutsche Tourenwagen Masters (DTM) — Чемпионат Германии среди легковых автомобилей (силуэт-прототипов).</p>
            <p>Автомобили DTM имеют следующие аэродинамические элементы: передний сплиттер, плоское днище с 2 диффузорами (за передней и задней осью), и большое заднее крыло.</p>
            <p>Впереди расположен 4-литровый мотор конфигурации V8 (угол развала — 90°), мощностью около 470—480 л.с. и крутящим моментом около 500 Н·м, на рестрикторы с внутренним диаметром 29 мм. Двигатель DTM должен работать без замены или капитального ремонта весь сезон (около 5000 км пробега), разрешается использовать 3 двигателя на 2 машины.</p>
            <p>Тормозные диски — карбоновые, вентилируемые, с легкосплавными колодками, стандартизированные, AP Racing, на сезон (и для передних, и для задних колес) предлагается 3 комплекта дисков и 9 комплектов колодок.</p>
            <p>Подвеска чисто гоночная, независимая, «двойной уишбон» (поперечный рычаг) на всех колёсах с толкаемой стойкой и регулируемыми газонаполненными амортизаторами, подобная машинам с открытыми колёсами.</p>
            <div class="news-pictures">
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news31.jpg" title="Travis Rice with friends" alt="news31">
                </figure>
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news32.jpg" title="Spot" alt="news32">
                </figure>
            </div>
        </div>
        <div class="news" id="Dragster">
            <h2><u>DRAGSTER</u>: СТАВИМ РЕКОРДЫ СКОРОСТИ</h2>
            <p>Соревнования по дрэг-рейсингу могут проводиться практически на любом виде транспорта, однако для профессиональных заездов строятся специальные автомобили, именуемые дрэгстерами. По своей конструкции дрэгстер представляет собой максимально облегчённую конструкцию с мощным мотором, органы управления, напротив, часто бывают достаточно примитивны, так как соревнования проводятся на идеально прямой трассе.</p>
            <p>Профессиональные дрэгстеры имеют мощность двигателя более 8000 л. с. и достигают 10-12 тысячи л. с. в высших категориях при собственной массе менее одной тонны. Подобные автомобили проходят дистанцию в четверть мили за 3,7-3,8 секунды и разгоняются до 500-530 км/ч, а скорости 100 км/ч достигают уже за 0,8 секунды.</p>
            <p>Рекорды NHRA: 1/4 мили за 4,428 секунды, 1000 футов (305 метров) за 3,701 секунды.</p>
            <div class="news-pictures">
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news41.jpg" title="DewTour" alt="news41">
                </figure>
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news42.jpg" title="Snow park" alt="news42">
                </figure>
            </div>
        </div>
        <div class="news" id="Bosozoku">
            <h2><u>BOSOZOKU</u>: СТРАННО, НО ПРИКОЛЬНО</h2>
            <p>Босодзоку — одна из самых известных субкультур Японии. Они появились как субкультура, состоящая из криминальных группировок лихачей-мотоциклистов, а вскоре часть босодзоку перешла на автомобили.</p>
            <p>Одна из самых примечательных особенностей субкультуры босодзоку — тюнинг их мотоциклов и автомобилей. Стиль босодзоку включает пять направлений тюнинга: сякотан, янки-стайл, вип-стайл, кося и гратян.</p>
            <p>Сякотан является исторически первым и классическим стилем босодзоку; основной его элемент — спортивные машины с заниженной подвеской. Янки-стайл представляет собой псевдогавайский стиль, навеянный гавайскими рубашками и белыми брюками из 70-80-х годов XX века. Большинство босодзоку того времени следовали этой моде и после того, как она прошла, выделились в отдельное направление. Вип-стайл — современное веяние в субкультуре босодзоку, который, в отличие от других подвидов, ориентируется прежде всего на современные машины представительского класса. Кося и гратян же предпочитают японские автомобили 80-х годов XX века и гоночные машины «Фудзи Спидвей» соответственно.</p>
            <div class="news-pictures">
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news51.jpg" title="Sceme 1" alt="news51">
                </figure>
                <figure>
                    <img src="${pageContext.request.contextPath}/resource/news52.jpg" title="Sceme 2" alt="news52">
                </figure>
            </div>
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
