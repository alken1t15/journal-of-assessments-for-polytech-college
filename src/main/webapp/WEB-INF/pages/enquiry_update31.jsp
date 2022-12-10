<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style><%@include file="./css/fio.css"%></style>
<style><%@include file="./css/fio-responsive.css"%></style>
<style><%@include file="./css/footer_responsive.css"%></style>
<style><%@include file="./css/header_responsive.css"%></style>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="./styles/fio.css">
  <link rel="stylesheet" href="./styles/fio-responsive.css">
  <link rel="stylesheet" href="./styles/footer_responsive.css">
  <link rel="stylesheet" href="./styles/header_responsive.css">
</head>

<body>
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

<div class="wrapper">
  <section class="content">
    <div class="container content-container">
      <div class="tabs-content tabs-content-2 tab-is-active" id="tab1">
        <div class="content-wrapper">
          <form:form action="enquiry_save" modelAttribute="calendarId">
            <p class="current-status">Редактирование оценок</p>
            <p class="current-student">${calendarId.lastName} ${calendarId.firstName} ${calendarId.middleName}</p>
            <p class="current-student">Группа: ${calendarId.groupName}</p>
            <p class="current-student">За месяц: ${calendarId.month}</p>
            <p class="current-student">По предмету: ${calendarId.itemName}</p>
            <p class="red">${errors}</p>
            <form:hidden path="id"/>
            <form:hidden path="teacher"/>
            <form:hidden path="student"/>
            <form:hidden path="firstName"/>
            <form:hidden path="middleName"/>
            <form:hidden path="lastName"/>
            <form:hidden path="groupName"/>
            <form:hidden path="itemName"/>
            <form:hidden path="month"/>
            <form:hidden path="days"/>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День1</p>
              </div>
              <div class="field-right">
                <form:input path="day1" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День2</p>
              </div>
              <div class="field-right">
                <form:input path="day2" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День3</p>
              </div>
              <div class="field-right">
                <form:input path="day3" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День4</p>
              </div>
              <div class="field-right">
                <form:input path="day4" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День5</p>
              </div>
              <div class="field-right">
                <form:input path="day5" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День6</p>
              </div>
              <div class="field-right">
                <form:input path="day6" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День7</p>
              </div>
              <div class="field-right">
                <form:input path="day7" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День8</p>
              </div>
              <div class="field-right">
                <form:input path="day8" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День9</p>
              </div>
              <div class="field-right">
                <form:input path="day9" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День10</p>
              </div>
              <div class="field-right">
                <form:input path="day10" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День11</p>
              </div>
              <div class="field-right">
                <form:input path="day11" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День12</p>
              </div>
              <div class="field-right">
                <form:input path="day12" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День13</p>
              </div>
              <div class="field-right">
                <form:input path="day13" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День14</p>
              </div>
              <div class="field-right">
                <form:input path="day14" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День15</p>
              </div>
              <div class="field-right">
                <form:input path="day15" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День16</p>
              </div>
              <div class="field-right">
                <form:input path="day16" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День17</p>
              </div>
              <div class="field-right">
                <form:input path="day17" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День18</p>
              </div>
              <div class="field-right">
                <form:input path="day18" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День19</p>
              </div>
              <div class="field-right">
                <form:input path="day19" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День20</p>
              </div>
              <div class="field-right">
                <form:input path="day20" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День21</p>
              </div>
              <div class="field-right">
                <form:input path="day21" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День22</p>
              </div>
              <div class="field-right">
                <form:input path="day22" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День23</p>
              </div>
              <div class="field-right">
                <form:input path="day23" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День24</p>
              </div>
              <div class="field-right">
                <form:input path="day24" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День25</p>
              </div>
              <div class="field-right">
                <form:input path="day25" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День26</p>
              </div>
              <div class="field-right">
                <form:input path="day26" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День27</p>
              </div>
              <div class="field-right">
                <form:input path="day27" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День28</p>
              </div>
              <div class="field-right">
                <form:input path="day28" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День29</p>
              </div>
              <div class="field-right">
                <form:input path="day29" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День30</p>
              </div>
              <div class="field-right">
                <form:input path="day30" class="input-field-b"/>
              </div>
            </div>
            <div class="field-box">
              <div class="field-left">
                <p class="field-left__text">День31</p>
              </div>
              <div class="field-right">
                <form:input path="day31" class="input-field-b"/>
              </div>
            </div>
            <input type="submit" class="btn" value="OK">
          </form:form>
        </div>
      </div>
    </div>
  </section>
</div>
<%--@elvariable id="calendarId" type="com"--%>
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

<script type="text/javascript" src="../../js/menu.js"></script>
</body>
</html>
