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
          <form:form action="enquiry_save_assessments" modelAttribute="semesterAssessment">
            <p class="current-status">Редактирование зачетной работы</p>
            <p class="current-student">${semesterAssessment.lastName} ${semesterAssessment.firstName} ${semesterAssessment.middleName}</p>
            <p class="current-student">Группа: ${semesterAssessment.groupName}</p>
            <p class="current-student">По предмету: ${semesterAssessment.itemName}</p>
            <p class="red">${errors}</p>
            <form:hidden path="id"/>
            <form:hidden path="teacher"/>
            <form:hidden path="student"/>
            <form:hidden path="firstName"/>
            <form:hidden path="middleName"/>
            <form:hidden path="lastName"/>
            <form:hidden path="groupName"/>
            <form:hidden path="itemName"/>
            <form:hidden path="semester"/>
            <div class="field-box field-box-n">
              <div class="field-left field-left-n">
                <p class="field-left__text field-left__text-n">Оценка за зачетную работу</p>
              </div>
              <div class="field-right">
                <form:input path="creditWork" class="input-field-b"/>
              </div>
            </div>
            <input type="submit" class="btn" value="OK">
          </form:form>
        </div>
      </div>
    </div>
  </section>
</div>
<%--@elvariable id="semesterAssessment" type="com"--%>
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
