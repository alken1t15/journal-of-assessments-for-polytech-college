<%--@elvariable id="login" type="com.example.demo.MyController"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<style><%@include file="profile.css"%></style>
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
    <link rel="stylesheet" href="./styles/profile.css">
</head>
<body>
    <header>
        <div class="container header-container">
            <a href="index.jsp" class="logo__link"><img class="logo" src="logo.svg" alt=""></a>
            <navbar class="navbar">
                <a href="#" class="navbar__link">Виртуальная приемная комиссия</a>
                <a href="#" class="navbar__link">Для абитурентов</a>
                <a href="#" class="navbar__link">Библиотека</a>
                <a href="#" class="navbar__link">Преподаватели</a>
                <a href="#" class="navbar__link">О колледже</a>
                <a href="profile.jsp" class="navbar__link navbar__link-profil navbar__link-profil-hidden"><img class="profile-photo-mini" src="profile.jfif" alt="Фото профиля"></a>
                <a href="#btn-sign" class="btn btn-sign">Вход</a>
            </navbar></div>
    </header>


    <section class="content">
        <div class="container content-container">
            <div class="tab-header">
                <button class="tabs__item is-active" data-tab="#tab1">Личная иноформация</button>
                <button class="tabs__item" data-tab="#tab2">Справки</button>
                <button class="tabs__item" data-tab="#tab3">Оценки</button> 
                <button class="tabs__item" data-tab="#tab4">Итоговые оценки</button>
                
            </div>
         
            <div class="tabs-content tabs-content-2 tab-is-active" id="tab1">
                <div class="content-wrapper">
                    <div class="content-left">
                        <div class="content-block">
                            <p class="content__person">Личная иноформация ФИО:</p>
                            <p class="info">${login.login}</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Дата рождения:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Пол:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Возраст:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Национальность:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Номер телефона:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Адрес прописки:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">ИИН:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">№удостоверения, дата выдачи, кем выдан:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Хобби:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Социальное положение:</p>
                            <p class="info">example</p>
                        </div>
                        <div class="content-block">
                            <p class="content__person">Место работы студента:</p>
                            <p class="info">example</p>
                        </div>
                    </div>
                    <div class="content-right">
                        <img src="profile.jfif" alt="Ваша фотография" class="content-img">
                    </div>
                </div>
            </div>
            <div class="tabs-content tabs-content-2" id="tab2">
                <div class="content-wrapper content-wrapper-2">
                    <div class="content-left">
                        <p class="content__person">Справки ФИО</p>
                        <img src="#" alt="" class="content__certificate">
                    </div>
                    <div class="content-right">
                        <img src="profile.jfif" alt="Ваша фотография" class="content-img">
                    </div>
                </div>
            </div>
            <div class="tabs-content tabs-content-2" id="tab3">
                <div class="content-wrapper content-wrapper-2">
                   <div class="block">  <table>
                    <tr>
                    <th>Название предмета</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    </tr>
                    <tr>
                    <td>А</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                       <tr>
                    <td>А</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                        <td>А</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        <td>5</td>
                        </tr>
                        <tr>
                            <td>А</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            <td>5</td>
                            </tr>
                            <tr>
                                <td>А</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                <td>5</td>
                                </tr>
                    <tr>
                    <td>Б</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                    <td>В</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                    <td>Г</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    </table></div>
                      
                    
                    
                </div>
            </div>
            <div class="tabs-content tabs-content-2" id="tab4">
                <div class="content-wrapper content-wrapper-2">
                   <div class="block">  <table>
                    <tr>
                    <th>Название предмета</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    <th>Высшая математика</th>
                    </tr>
                    <tr>
                    <td>А</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                    <td>Б</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                    <td>В</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    <tr>
                    <td>Г</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    <td>5</td>
                    </tr>
                    </table></div>
                      
                    
                    
                </div>
            </div>
        </div>
    </section>



    <footer class="footer">
        <div class="container footer-container">
            <div class="footer-logo"><a href="index.jsp" class="logo__link"><img class="logo big-logo" src="logo.svg" alt=""></a></div>
            <div class="footer-main-col">
                <p class="footer__title">Полезные ссылки</p>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a> 
            </div>
            <div class="footer-main-col">
                <p class="footer__title">Полезные ссылки</p>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a>
                <a href="#" class="footer__link">Полезные ссылки</a> 
            </div>
            <div class="footer-main-col footer-social-col">
                <p class="footer__title">Мы в социальных сетях:</p>
                <div class="social-container"> <a href="#" class="footer__link"><img src="Instagram.svg" alt="логотип Instagram" class="footer__img"></a>
                    <a href="#" class="footer__link"><img src="tg.svg" alt="логотип telegram" class="footer__img"></a>
                    <a href="#" class="footer__link"><img src="vk.svg" alt="логотип Vk" class="footer__img"></a>
                    <a href="#" class="footer__link"><img src="fb.svg" alt="логотип FaceBook" class="footer__img"></a>
                </div>
            </div>
        </div>
    </footer>


    
    <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
    <script type="text/javascript" src="index.js"></script>
    <script type="text/javascript" src="profile.js"></script>
</body>
</html>