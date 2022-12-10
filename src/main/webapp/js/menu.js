let buttonsOpen = document.querySelector(".button-open")
let navbar = document.querySelector(".navbar")
let body = document.querySelector("body")
let line = document.querySelectorAll(".line")

buttonsOpen.addEventListener('click', function (){
    navbar.classList.toggle("navbar-active")
    line.forEach(function (val,index){
        val.classList.toggle("line"+index);
    });
    body.classList.toggle("body-h")
});