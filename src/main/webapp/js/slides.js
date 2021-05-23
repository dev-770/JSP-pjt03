$(document).ready(function () {
  var mySwiper = new Swiper ('.swiper-container.s1', {
    direction: 'horizontal',
		effect: 'fade',
		loop:true,
		autoplay: {
			delay: 5000,
		},
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		}
	})

	var mySwiper2 = new Swiper ('.swiper-container.s2', {
    direction: 'horizontal',
		loop:true,
		autoplay: {
			delay: 3000,
		},
		navigation: {
			nextEl: '.swiper-button-next',
			prevEl: '.swiper-button-prev',
		},
		slidesPerView: 4,
		spaceBetween: 10,

		breakpoints: {
		480: {
			slidesPerView: 1,
			spaceBetween: 0
		},
		800: {
			slidesPerView: 2,
			spaceBetween: 50
		},
		1000: {
			slidesPerView: 4,
			spaceBetween: 100
		}
	}
	})

});



















































// const Slidebox = document.querySelector('.slider_box'), //slider_box
// 	conSlide = document.querySelector('.con_slider'), // con_slider
// 	Slideitem = document.querySelectorAll('.con_slider_item'), // con_slider_item
// 	SlideCount = Slideitem.length, // 슬라이드 개수
// 	Prev = document.getElementById('prev'),
// 	Next = document.getElementById('next');
// 	let currentIndex = 0; // 구분자

// 	// console.log(Next);
// 	// console.log(SlideCount);

// 	function goSlide(idx) {
// 		conSlide.style.left = idx * -25 + '%';
// 		conSlide.classList.add('animation');
// 		currentIndex = idx;
// 	}

// 	Prev.addEventListener('click', function(e){
// 		e.preventDefault();
// 		if(currentIndex > 0) {
// 			goSlide(currentIndex - 1);
// 		}else {
// 			goSlide(SlideCount - 4);
// 		}
// 	});
	
// 	Next.addEventListener('click', function(e){
// 		e.preventDefault();
// 		if(currentIndex < SlideCount-4) {
// 			goSlide(currentIndex + 1);
// 		}else {
// 			goSlide(0);
// 		}
// 	});



































	// const SHOWING_CLASS = "showing";
	// const firstSlide = document.querySelector(".main_slider_item:first-child")
	// const lastSlide = document.querySelector(".main_slider_item:last-child");
	
	// function slide() {
	// 	const currentSlide = document.querySelector(`.${SHOWING_CLASS}`)
	// 	if(currentSlide) {
	// 		currentSlide.classList.remove(SHOWING_CLASS);
	// 		const nextSlide = currentSlide.nextElementSibling;
	// 		if(nextSlide) {
	// 			nextSlide.classList.add(SHOWING_CLASS);
	// 		} else {
	// 			firstSlide.classList.add(SHOWING_CLASS);
	// 		}
	// 	} else {
	// 		firstSlide.classList.add(SHOWING_CLASS);
	// 	}
	// }
	// slide();
	// setInterval(slide, 5000);
	
	
	
	















// function nextSlide() {
//   const currentSlide = document.querySelector('.showing');
//   if(currentSlide) {
//     currentSlide.classList.remove('showing');
//     const nextSlide = currentSlide.nextElementSibling;

//     if(nextSlide) {
//       nextSlide.classList.add('showing');
//     } else {
//       firstSlide.classList.add('showing');
//     }
//   } else {
//     firstSlide.classList.add('showing');
//   }
// }

// function prevSlide() { 
//   const currentSlide = document.querySelector('.showing');
//   if(currentSlide) {
//     currentSlide.classList.remove('showing');
//     const prevSlide = currentSlide.previousElementSibling;
    
//     if(prevSlide) {
//       prevSlide.classList.add('showing');
//     } else {
//       lastSlide.classList.add('showing');
//     }
//   } else {
//     lastSlide.classList.add('showing');
//   }
// }

// document.getElementById('prev').addEventListener('click', prevSlide);
// document.getElementById('next').addEventListener('click', nextSlide);