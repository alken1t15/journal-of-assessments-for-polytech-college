let buttons = document.getElementsByClassName("btn"),
    forEach = Array.prototype.forEach;

forEach.call(buttons, function (b) {
    b.addEventListener('click', addElement);
});

function addElement(e){
    let addDiv = document.createElement('div'),
        mValue = Math.max(this.clientWidth, this.clientHeight),
        rect   = this.getBoundingClientRect();
        sDiv   = addDiv.style,
        px     = 'px';

    sDiv.width = sDiv.height = mValue + px;
    sDiv.left  = e.clientX - rect.left - (mValue / 2) + px;
    sDiv.top  = e.clientY - rect.top - (mValue / 2) + px; 

    addDiv.classList.add('pulse');
    this.appendChild(addDiv);
};

const swiper = new Swiper('.swiper', {
    slidesPerView: 1,
    spaceBetween: 10,
    navigation: {
        nextEl: '.next-arrow',
        prevEl: '.prev-arrow'
    },
    grabCursor: true, 
    keyboard: {
        enabled: true,
        onlyInViewport: true,
        pageUpDown: true,
    },
    loop: true,
    autoplay: {
        delay: 5000,
        stopOnLastSlide: false,
        disableOnInteraction: false,
    },
    speed: 1000,
  });

let point = [51.177697, 71.417484]

ymaps.ready(init);
    function init(){
        var myMap = new ymaps.Map("map", {
            center: point,
            zoom: 16,
        });
        let placeMark = new ymaps.Placemark(point, {
            hintContent: 'Политехнический колледж г.Астаны',
            balloonContent: 'Лучший колледж в Казахстане',
        },
        {
            iconLayout: 'default#image',
            iconImageHref: ("../img/map-point.png"),
            iconImageSize: [40,40],
            iconImageOffset: [-20,-30],
        
                

        });
        myMap.geoObjects
                .add(placeMark)
                .add(placeMarkWithContent);
        placeMark.options.set('balloonContentLayoutHeight', 200);
        placeMark.options.set('balloonContentLayoutWidth', 300);
    }


const btnLinks = document.querySelectorAll(".btn-sign");
const modals = document.querySelector(".sing-in");
const body = document.querySelector('body');

if(btnLinks.length > 0){
    for(let index = 0; index < btnLinks.length; index++){
        const btnLink = btnLinks[index];
        btnLink.addEventListener('click', function(e){
            modals.classList.add('modal-active');
            body.style.overflow = "hidden";
            //let scrollHeight = document.body.scrollHeight;
            //body.style.padding = scrollHeight + "px";
            // e.preventDefault();
           
        });
    }
}

const btnsClose = document.querySelectorAll('.sign-in__close');
if(btnsClose.length > 0){
    for(let index = 0; index < btnsClose.length; index++){
        const btnClose = btnsClose[index];
        btnClose.addEventListener('click', function(e){
            modals.classList.remove('modal-active');
            body.style.overflow = "scroll";
            e.preventDefault();
        });
    }
}
