<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8"%>
<style><%@include file="index.css"%></style>
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
    <title>APC главная страница</title>
</head>
<body>
<div>
    <%--@elvariable id="error" type="com"--%>



<%--@elvariable id="login" type="com.example.demo"--%>


<form:form  method="post">
    <input  name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <p class="field-left__text">Логин</p>
   <input type="text" name="username" id="username" class="input-field" placeholder="Ваш логин" required minlength="5" >
    <p class="field-left__text">Пароль</p>
    <input type="password" name="password" class="input-field" placeholder="Ваш пароль" required minlength="6">
    <c:if test="${error == true}">
        <p role="alert">ОШИБКА</p>
    </c:if>
    <button type="submit"  class="btn btn-sn">Войти</button>
</form:form>
<%--    <form  method="post" >--%>
<%--        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">--%>
<%--        <p class="field-left__text">Логин</p>--%>
<%--        <input type="text" name="username" id="username" class="input-field" placeholder="Ваш логин" required minlength="5" >--%>
<%--        <p class="field-left__text">Пароль</p>--%>
<%--        <input type="password" name="password" class="input-field" placeholder="Ваш пароль" required minlength="6">--%>
<%--            <c:if test="${error == true}">--%>
<%--                <p role="alert">ОШИБКА</p>--%>
<%--            </c:if>--%>
<%--        <button type="submit"  class="btn btn-sn" onclick="window.location.href = 'profileInput'">Войти</button>--%>
<%--        <p>${text}</p>--%>
<%--    </form>--%>

</div>

<script src="https://api-maps.yandex.ru/2.1/?apikey=9b601e88-cb69-42b4-9221-08e3f5d37380&lang=ru_RU" type="text/javascript">
</script>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script type="text/javascript" src="index.js"></script>
<%--<script src="./script/index.js"></script>--%>
</body>
</html>