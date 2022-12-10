<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<style><%@include file="./css/fio.css"%></style>
<style><%@include file="./css/fio-responsive.css"%></style>
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
    <title>Журнал оценок</title>
    <link rel="stylesheet" href="./styles/fio.css">
    <link rel="stylesheet" href="./styles/fio-responsive.css">
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
                <security:authorize access="hasRole('TEACHER')">
                    <a href="/profile" class="navbar__link navbar__link-profil navbar__link-profil-hidden"><img class="profile-photo-mini" src="./img/${people.name_img}" alt="Фото профиля"></a>
                    <form method="post">
                        <a class="btn btn-out" href="<c:url value="/logout" />">Выйти</a>
                    </form>
                </security:authorize>
                <security:authorize access="hasRole('STUDENT')">
                    <a href="/profile" class="navbar__link navbar__link-profil navbar__link-profil-hidden"><img class="profile-photo-mini" src="./img/${people.name_img}" alt="Фото профиля"></a>
                    <form method="post">
                        <a class="btn btn-out" href="<c:url value="/logout" />">Выйти</a>
                    </form>
                </security:authorize>
                <security:authorize access="isAnonymous()">
                    <a href="/profile" class="btn btn-sign">Вход</a>
                </security:authorize>
            </navbar>
            <button class="button-open">
                <div class="line"></div>
                <div class="line"></div>
                <div class="line"></div>
            </button></div>
    </header>
    <section class="content">
        <div class="container content-container">
            <div class="tab-header">
                <a href="/profile" class="tabs__item"           data-tab="#tab3">Личная информация</a>
                <a href="/enquiry-td" class="tabs__item is-active"           data-tab="#tab3">Оценки</a>
                <a href="/enquiry-tm" class="tabs__item"           data-tab="#tab4">Атестационные оценки</a>
                <a href="/fio_t" class="tabs__item"           data-tab="#tab5">Информация о студенте</a>
                <a href="/enquiry_t" class="tabs__item"           data-tab="#tab5">Справки студента</a>
            </div>
            <div class="tabs-content tabs-content-2 tab-is-active" id="tab3">
                <p class="main-info">${schedules.status}</p>
                <p class="current-status">${schedules.month}</p>
                <p class="current-status">${schedules.nameGroup}</p>
                <p class="current-status">${schedules.nameItem}</p>
                <div class="content-wrapper content-wrapper-2">
                    <div class="block">
                        <%--@elvariable id="schedules" type="com"--%>
                            <form:form action="enquiry-td" modelAttribute="schedules" method="get">
                                <form:select path="month">
                                    <form:option value="Сентябрь" label="Сентябрь"/>
                                    <form:option value="Октябрь" label="Октябрь"/>
                                    <form:option value="Ноябрь" label="Ноябрь"/>
                                    <form:option value="Декабрь" label="Декабрь"/>
                                    <form:option value="Январь" label="Январь"/>
                                    <form:option value="Февраль" label="Февраль"/>
                                    <form:option value="Март" label="Март"/>
                                    <form:option value="Апрель" label="Апрель"/>
                                    <form:option value="Май" label="Май"/>
                                    <form:option value="Июнь" label="Июнь"/>
                                </form:select>
                                <form:select path="status">
                                    <form:option value="Журнал оценок" label="Журнал оценок"/>
                                    <form:option value="Журнал посещения" label="Журнал посещения"/>
                                </form:select>
                                <form:select path="nameGroup">
                                    <form:options items="${schedules.nameGroups}"/>
                                </form:select>
                                <form:select path="nameItem">
                                    <form:options items="${schedules.nameItems}"/>
                                </form:select>
                                <input class="btn" type="submit" value="Поиск" onclick="window.location.href='/enquiry-td'">
                            </form:form>
                        <table>
                            <tr>
                                <th>ФИО студента</th>
                                <th>Название предмета</th>
                                <% int count = 31; %>
                                <%
                                    for(int i = 1; i <= count; i++) { %>
                                <th>День  <%= i %></th>
                                <% } %>
                                <th>Количество пропусков</th>
                            </tr>
                            <c:forEach var="emp" items="${calendar}">

                            <с:url var="deleteButton" value="http://localhost:8080/enquiry_updateH">
                                <c:param name="empId" value="${emp.id}"/>
                            </с:url>
                            <tr>
                                <td>${emp.lastName} ${emp.firstName} ${emp.middleName}</td>
                                <td>${emp.itemName}</td>
                                <td>${emp.day1}</td>
                                <td>${emp.day2}</td>
                                <td>${emp.day3}</td>
                                <td>${emp.day4}</td>
                                <td>${emp.day5}</td>
                                <td>${emp.day6}</td>
                                <td>${emp.day7}</td>
                                <td>${emp.day8}</td>
                                <td>${emp.day9}</td>
                                <td>${emp.day10}</td>
                                <td>${emp.day11}</td>
                                <td>${emp.day12}</td>
                                <td>${emp.day13}</td>
                                <td>${emp.day14}</td>
                                <td>${emp.day15}</td>
                                <td>${emp.day16}</td>
                                <td>${emp.day17}</td>
                                <td>${emp.day18}</td>
                                <td>${emp.day19}</td>
                                <td>${emp.day20}</td>
                                <td>${emp.day21}</td>
                                <td>${emp.day22}</td>
                                <td>${emp.day23}</td>
                                <td>${emp.day24}</td>
                                <td>${emp.day25}</td>
                                <td>${emp.day26}</td>
                                <td>${emp.day27}</td>
                                <td>${emp.day28}</td>
                                <td>${emp.day29}</td>
                                <td>${emp.day30}</td>
                                <td>${emp.day31}</td>
                                <td>${emp.result}</td>
                                <td>
                                    <input type="button" value="Поставить Н" onclick="window.location.href='${deleteButton}'"/>
                                </td>
                            <tr>
                                </c:forEach>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<footer class="footer">
    <div class="container footer-container">
        <div class="footer-logo"><a href="index.html" class="logo__link"><img class="logo big-logo" src="./img/logo.svg" alt=""></a></div>
        <div class="footer-main-col">
            <p class="footer__title">Полезные ссылки</p>
            <a href="/exchange" class="footer__link">Замены</a>
            <a href="/specialty" class="footer__link">Специальности</a>
            <a href="/resourses" class="footer__link">Электронные ресурсы</a>
            <a href="/contacts" class="footer__link">Контакты</a>
        </div>
        <div class="footer-main-col">
            <p class="footer__title">Полезные ссылки</p>
            <security:authorize access="isAnonymous()">
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