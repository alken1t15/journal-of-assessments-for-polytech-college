<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
<style><%@include file="./css/educator.css"%></style>
<style><%@include file="./css/educator-responsive.css"%></style>
<style><%@include file="./css/footer_responsive.css"%></style>
<style><%@include file="./css/header_responsive.css"%></style>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"
    />

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500;700;900&family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    <title>Преподаватели</title>
    <link rel="stylesheet" href="./styles/educator.css">
    <link rel="stylesheet" href="./styles/educator-responsive.css">
    <link rel="stylesheet" href="./styles/footer_responsive.css">
    <link rel="stylesheet" href="./styles/header_responsive.css">
</head>
<body>
<div class="wrapper">
    <header>
        <div class="container header-container">
            <a href="/" class="logo__link"><img class="logo" src="./img/logo.svg" alt=""></a>
            <navbar class="navbar">
                <a href="exchange" class="navbar__link">Замены</a>
                <a href="shedule" class="navbar__link">Расписание</a>
                <a href="specialty" class="navbar__link">Специальности</a>
                <a href="resourses" class="navbar__link">Электронные ресурсы</a>
                <a href="educator" class="navbar__link">Преподаватели</a>
                <a href="contacts" class="navbar__link">Контакты</a>
                <security:authorize access="hasRole('TEACHER')"> <%--  access="hasRole('HR') указываеться роля кому будет видна--%>
                    <a href="/profile" class="navbar__link navbar__link-profil navbar__link-profil-hidden"><img class="profile-photo-mini" src="./img/${people.name_img}" alt="Фото профиля"></a>
                    <form method="post">
                        <a class="btn btn-out" href="<c:url value="/logout" />">Выйти</a>
                    </form>
                </security:authorize>
                <security:authorize access="hasRole('STUDENT')"> <%--  access="hasRole('HR') указываеться роля кому будет видна--%>
                    <a href="/profile" class="navbar__link navbar__link-profil navbar__link-profil-hidden"><img class="profile-photo-mini" src="./img/${people.name_img}" alt="Фото профиля"></a>
                    <form method="post">
                        <a class="btn btn-out" href="<c:url value="/logout" />">Выйти</a>
                    </form>
                </security:authorize>
                <security:authorize access="isAnonymous()"> <%--  access="hasRole('HR') указываеться роля кому будет видна--%>
                    <a href="/profile" class="btn btn-sign">Вход</a>
                </security:authorize>
            </navbar>
            <button class="button-open">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </button></div>
    </header>




</div>
<section class="content">
    <div class="container content-container">

        <div class="tabs-content tabs-content-2 tab-is-active" id="tab3">
            <div class="content-wrapper content-wrapper-2">
                <%--@elvariable id="studentInfo" type="com"--%>
                <form:form action="/educator" modelAttribute="studentInfo" method="get">
                    <form:select path="fistLastMiddleName">
                        <form:options items="${studentInfo.fistLastMiddleNames}"/>
                    </form:select>
                    <input class="btn btn-ed" type="submit" value="Поиск" onclick="window.location.href='/educator'"/>
                </form:form>
                <div class="block">  <table>
                    <tr>
                        <th>Фамилия Преподавателя</th>
                        <th>Имя Преподавателя</th>
                        <th>Отчество Преподавателя</th>
                        <th>Предметы преподавателя</th>
                        <th>Аудитория</th>
                    </tr>
                    <c:forEach var="emp" items="${teacher}">
                    <tr>
                        <td>${emp.lastName}</td>
                        <td>${emp.firstName}</td>
                        <td>${emp.middleName}</td>
                        <td>${emp.itemName}</td>
                        <td>${emp.audience}</td>
                    <tr>
                        </c:forEach>
                    </tr>
                </table></div>



            </div>
        </div>

    </div>
</section>




<footer class="footer">
    <div class="container footer-container">
        <div class="footer-logo"><a href="/" class="logo__link"><img class="logo big-logo" src="./img/logo.svg" alt=""></a></div>
        <div class="footer-main-col">
            <p class="footer__title">Полезные ссылки</p>
            <a href="/exchange" class="footer__link">Замены</a>
            <a href="/specialty" class="footer__link">Специальности</a>
            <a href="/resourses" class="footer__link">Электронные ресурсы</a>
            <a href="/contacts" class="footer__link">Контакты</a>
        </div>
        <div class="footer-main-col">
            <p class="footer__title">Полезные ссылки</p>
            <security:authorize access="isAnonymous()"> <%--  access="hasRole('HR') указываеться роля кому будет видна--%>
                <a href="/profile" class="footer__link">Войти в профиль</a>
            </security:authorize>
            <a href="/educator" class="footer__link">Преподаватели</a>
            <a href="/kdm.html" class="footer__link">Комитет по делам молодежи</a>
            <a href="/shedule" class="footer__link">Расписание</a>
        </div>
        <div class="footer-main-col footer-social-col">
            <p class="footer__title">Мы в социальных сетях:</p>
            <div class="social-container">
                <a href="https://www.instagram.com/apc_stories/" class="footer__link"><img src="./img/Instagram.svg" alt="логотип Instagram" class="footer__img"></a>
                <a href="https://t.me/polytech_astana" class="footer__link"><img src="./img/tg.svg" alt="логотип telegram" class="footer__img"></a>
                <a href="https://vk.com/polytech_astana" class="footer__link"><img src="./img/vk.svg" alt="логотип Vk" class="footer__img"></a>
                <a href="https://www.facebook.com/polytech.astana/" class="footer__link"><img src="./img/fb.svg" alt="логотип FaceBook" class="footer__img"></a>
            </div>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script src="./script/index.js"></script>
<script type="text/javascript" src="../../js/menu.js"></script>
</body>
</html>