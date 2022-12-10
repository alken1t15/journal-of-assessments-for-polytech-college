<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8"%>
<style><%@include file="./css/index.css"%></style>
<style><%@include file="./css/footer_responsive.css"%></style>
<style><%@include file="./css/header_responsive.css"%></style
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
    <title>Главная страница</title>  
    <link rel="stylesheet" href="./styles/index.css">
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
<section class="hero">
        <div class="swiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <div class="swiper-text-block">
                    <div class="container slider-container">
                        <h3 class="slider-title">Astana<br>Polytechnic<br>College</h3>
                        <p class="slider-subtitle">Получите профессию будущего<br>в лучшем колледже Казахстана </p>
                    </div>
                </div>
                <div class="container">
                    <img src="./img/slider-1.jfif" class="slider-img" alt=""></div>
                </div>

              <div class="swiper-slide"><div class="swiper-text-block">
                <div class="container slider-container">
                    <h3 class="slider-title">Astana<br>Polytechnic<br>College</h3>
                    <p class="slider-subtitle">Новая программа обучения</p>
                </div>
            </div>
                  <div class="container">
                      <img src="./img/slider-2.jfif" class="slider-img" alt=""></div></div>

              <div class="swiper-slide"><div class="swiper-text-block">
                <div class="container slider-container">
                    <h3 class="slider-title">Astana<br>Polytechnic<br>College</h3>
                    <p class="slider-subtitle">Наши выпусники занимают<br>лидирующие позиции в рынке</p>
                </div>
            </div>
                  <div class="container">
                      <img src="./img/slider-3.jfif" class="slider-img" alt=""></div>
              </div>
              </div>
            </div>
                <svg class="slider-arr prev-arrow" width="59" height="75" viewBox="0 0 59 75" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M41.9468 20.5375V26.6998C41.9468 27.124 41.7695 27.517 41.4819 27.7288L29.7383 36.3986C29.1189 36.8563 29.1189 37.9998 29.7383 38.4574L41.4825 47.1273C41.7701 47.3398 41.9473 47.7321 41.9473 48.1563V54.3186C41.9473 55.2332 41.1728 55.8053 40.5534 55.3477L17.6739 38.4567C17.0545 37.999 17.0545 36.8556 17.6739 36.3979L40.5528 19.5077C41.1722 19.0508 41.9468 19.6221 41.9468 20.5375Z" fill="white" fill-opacity="0.67"/>
                <path d="M41.4819 47.1273L40.1013 46.1079C40.0938 46.1399 40.088 46.1748 40.0828 46.209L40.3204 46.3843C40.608 46.5968 40.7852 46.9891 40.7852 47.4134V53.5756C40.7852 54.3246 40.2658 54.8335 39.7376 54.7458L40.5534 55.3477C41.1728 55.8053 41.9474 55.2332 41.9474 54.3186V48.1563C41.9468 47.7314 41.7696 47.3391 41.4819 47.1273Z" fill="white" fill-opacity="0.67"/>
                <path d="M29.7383 36.3986L41.4825 27.7287C41.7701 27.5162 41.9473 27.1239 41.9473 26.6997V20.5374C41.9473 19.7089 41.3128 19.1703 40.7324 19.414C40.7637 19.5329 40.7852 19.6577 40.7852 19.7944V25.9567C40.7852 26.3809 40.608 26.774 40.3204 26.9857L28.5762 35.6556C28.5308 35.6942 28.1433 36.0389 28.1113 36.6846C28.0782 37.3615 28.4652 37.7746 28.5024 37.8124C28.8737 38.1416 29.2444 38.47 29.6157 38.7991C29.5971 38.7159 29.575 38.5673 29.6267 38.4202C29.6331 38.4016 29.6407 38.3838 29.6482 38.3682C29.1276 37.8682 29.1526 36.8302 29.7383 36.3986Z" fill="white" fill-opacity="0.67"/>
                <path d="M41.9468 20.5375V26.6998C41.9468 27.124 41.7695 27.517 41.4819 27.7288L29.7383 36.3986C29.1189 36.8563 29.1189 37.9998 29.7383 38.4574L41.4825 47.1273C41.7701 47.3398 41.9473 47.7321 41.9473 48.1563V54.3186C41.9473 55.2332 41.1728 55.8053 40.5534 55.3477L17.6739 38.4567C17.0545 37.999 17.0545 36.8556 17.6739 36.3979L40.5528 19.5077C41.1722 19.0508 41.9468 19.6221 41.9468 20.5375Z" fill="white" fill-opacity="0.67"/>
                </svg>
                <a href=""></a>
                <svg class="slider-arr next-arrow" width="59" height="75" viewBox="0 0 59 75" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M41.9468 20.5375V26.6998C41.9468 27.124 41.7695 27.517 41.4819 27.7288L29.7383 36.3986C29.1189 36.8563 29.1189 37.9998 29.7383 38.4574L41.4825 47.1273C41.7701 47.3398 41.9473 47.7321 41.9473 48.1563V54.3186C41.9473 55.2332 41.1728 55.8053 40.5534 55.3477L17.6739 38.4567C17.0545 37.999 17.0545 36.8556 17.6739 36.3979L40.5528 19.5077C41.1722 19.0508 41.9468 19.6221 41.9468 20.5375Z" fill="white" fill-opacity="0.67"/>
                    <path d="M41.4819 47.1273L40.1013 46.1079C40.0938 46.1399 40.088 46.1748 40.0828 46.209L40.3204 46.3843C40.608 46.5968 40.7852 46.9891 40.7852 47.4134V53.5756C40.7852 54.3246 40.2658 54.8335 39.7376 54.7458L40.5534 55.3477C41.1728 55.8053 41.9474 55.2332 41.9474 54.3186V48.1563C41.9468 47.7314 41.7696 47.3391 41.4819 47.1273Z" fill="white" fill-opacity="0.67"/>
                    <path d="M29.7383 36.3986L41.4825 27.7287C41.7701 27.5162 41.9473 27.1239 41.9473 26.6997V20.5374C41.9473 19.7089 41.3128 19.1703 40.7324 19.414C40.7637 19.5329 40.7852 19.6577 40.7852 19.7944V25.9567C40.7852 26.3809 40.608 26.774 40.3204 26.9857L28.5762 35.6556C28.5308 35.6942 28.1433 36.0389 28.1113 36.6846C28.0782 37.3615 28.4652 37.7746 28.5024 37.8124C28.8737 38.1416 29.2444 38.47 29.6157 38.7991C29.5971 38.7159 29.575 38.5673 29.6267 38.4202C29.6331 38.4016 29.6407 38.3838 29.6482 38.3682C29.1276 37.8682 29.1526 36.8302 29.7383 36.3986Z" fill="white" fill-opacity="0.67"/>
                    <path d="M41.9468 20.5375V26.6998C41.9468 27.124 41.7695 27.517 41.4819 27.7288L29.7383 36.3986C29.1189 36.8563 29.1189 37.9998 29.7383 38.4574L41.4825 47.1273C41.7701 47.3398 41.9473 47.7321 41.9473 48.1563V54.3186C41.9473 55.2332 41.1728 55.8053 40.5534 55.3477L17.6739 38.4567C17.0545 37.999 17.0545 36.8556 17.6739 36.3979L40.5528 19.5077C41.1722 19.0508 41.9468 19.6221 41.9468 20.5375Z" fill="white" fill-opacity="0.67"/>
                </svg>
          </div>
    </section>
    <section class="about" id="about">
        <div class="container about-container">
            <div class="about-left">
                <p class="about-left__text">25<br>лет<br>опыта</p>
                <img class="about-left__img" src="./img/about-img.png" alt="Фото Политехнического колледжа">
            </div>
            <div class="about-right">
                <h4 class="about__title">Политехнический колледж Астаны - это колледж профессионального образования
                    и  развития</h4>
                <p class="about__text"><strong style="color: #000;">Политехнический колледж Астаны</strong> идет в ногу с мировыми трендами и обучает всех абитурентов актуальными знаниями. Колледж был посроен в 1994 г. в качестве Центра обучения на базе четырех техникумов, вобрал в себя лучшее из того передового опыта, который десятилетиями помогал педагогам города готовить блестящие профессиональные кадры республики. </p>
                <div class="contact">
                    <div class="contact__img"></div>    
                    <a href="tel:+7 (705) 760 9593" class="contact__text">Связаться с нами: +7 (705) 760 9593</a>
                </div>
            </div>
        </div>
    </section>
    <section class="mission">
        <div class="mission-left">
            <div class="container-mini mission-container-mini">
                <h4 class="mission-left__title">Миссия Политехнического колледжа
                    Астаны</h4>
                    <p class="mission-left__text">повышение эффективности и качества предоставления образовательных услуг при непосредственном взаимодействии с производственной базой, с учетом направленности колледжа по подготовке высококвалифицированных специалистов конкурентоспособных на мировом рынке труда, улучшение позиции университета в национальных и международных рейтингах.</p>    
            </div>
            </div>
        <div class="mission-right">
            <div class="mission-item">
                <span class="mission-item__number">11</span>
                <span class="mission-item__text">Образовательных программ</span>
            </div>
            <div class="mission-item">
                <span class="mission-item__number">3000</span>
                <span class="mission-item__text">Обучающихся</span>
            </div>
            <div class="mission-item">
                <span class="mission-item__number">300</span>
                <span class="mission-item__text">Преподавателей</span>
            </div>
            <div class="mission-item">
                <span class="mission-item__number">625</span>
                <span class="mission-item__text">Выпусков</span>
            </div>
        </div>
    </section>

    <section class="reason">
        <div class="container">
            <p class="reason__title">Причины почему люди выбирают нас</p>
            <div class="reason-box">
                <div class="reason-item">
                    <img src="./img/reason-1.svg" alt="Price" class="reason__img">
                    <p class="reason__text">Выгодная цена</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-2.svg" alt="Price" class="reason__img">
                    <p class="reason__text">Лучшие преподаватели</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-3.svg" alt="Price" class="reason__img">
                    <p class="reason__text">Выпускники востребованы на предприятиях</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-4.svg" alt="Price" class="reason__img reason__img-4">
                    <p class="reason__text">Индивидуальный подход к каждому студенту</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-5.svg" alt="Price" class="reason__img">
                    <p class="reason__text">Современная программа</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-6.svg" alt="Price" class="reason__img">
                    <p class="reason__text">Много практики</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-7.svg" alt="Price" class="reason__img reason__img-7">
                    <p class="reason__text">Постоянная практическая работа</p>
                </div>
                <div class="reason-item">
                    <img src="./img/reason-8.svg" alt="Price" class="reason__img reason__img-8">
                    <p class="reason__text">Возможность обучаться бесплатно </p>
                </div>
            </div>
        </div>
    </section>
    <section class="contacts">
        <div class="container contacts-container">
            <h5 class="contacts__title">Контакты</h5>
            <div class="contacts-inner">
                <div class="contacts-left">
                    <div class="contacts-item">
                        <img src="./img/contacts-1.svg" alt="Икнока адреса" class="contacts-item__img">
                        <p class="contacts-item__text">Республика Казахстан, г.Нур-Султан, район Сарыарка, ул.Бейбітшілік 39</p>
                    </div>
                    <div class="contacts-item">
                        <img src="./img/contacts-2.svg" alt="Икнока адреса" class="contacts-item__img">
                        <p class="contacts-item__text"><a href="tel:8 (7172) 50 14 81">8 (7172) 50 14 81</a>, <a href="tel:8 (7172) 68-07-20">8 (7172) 68-07-20</a>, <a href="tel:+7 705 760 9593">+7 705 760 9593</a> (Приемная комиссия)</p>
                    </div>
                    <div class="contacts-item">
                        <img src="./img/contacts-3.svg" alt="Икнока адреса" class="contacts-item__img">
                        <a class="contacts-item__text" href="mailto:polytech@polytech.kz">E-mail:<br>polytech@polytech.kz</a>
                    </div>
                </div>
                <div class="contacts-right">
                    <div id="map" style="width: 300px; height: 300px;"></div>
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

    <script src="https://api-maps.yandex.ru/2.1/?apikey=9b601e88-cb69-42b4-9221-08e3f5d37380&lang=ru_RU" type="text/javascript">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
    <script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/menu.js"></script>
</body>
</html>