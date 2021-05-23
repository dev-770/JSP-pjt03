const toggle = document.querySelector('.nav_toggle');
const menu = document.querySelector('.nav_menu');
const login = document.querySelector('.nav_login');

const maintop = document.querySelectorAll('.main_slider_item');


// const drop1 = document.querySelector('.drop1');
// const drop2 = document.querySelector('.drop2');
// const drop3 = document.querySelector('.drop3');
// const sub1 = document.querySelector('.sub1');
// const sub2 = document.querySelector('.sub2');
// const sub3 = document.querySelector('.sub3');
// drop1.addEventListener('click', function(){
//     sub1.classList.toggle('active');
//     sub2.classList.remove('active');
//     sub3.classList.remove('active');
// });
// drop2.addEventListener('click', function(){
//     sub2.classList.toggle('active');
//     sub1.classList.remove('active');
//     sub3.classList.remove('active');
// });
// drop3.addEventListener('click', function(){
//     sub3.classList.toggle('active');
//     sub1.classList.remove('active');
//     sub2.classList.remove('active');
// });


toggle.addEventListener('click', () => {
    menu.classList.toggle('active');
    login.classList.toggle('active');

    for(let i=0; i < maintop.length; i++) {
        maintop[i].classList.toggle('acitve');
    }
});
console.log(toggle);

