<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/main.css">
    
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"> <!-- icon setting -->
    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="js/menu.js" defer></script>
    <script src="js/slides.js" defer></script>
    <title>Skydigital</title>
  </head>
  <body>

  <jsp:include page="header.jsp" flush="true"/>
	
    <section>
      <div class="main-slide">
        <div class="swiper-container s1">
          <div class="swiper-wrapper">
            <img class="swiper-slide" src="img/main1.jpg">
            <img class="swiper-slide" src="img/main2.jpg">
            <img class="swiper-slide" src="img/main3.jpg">
            <img class="swiper-slide" src="img/main4.jpg">
            <img class="swiper-slide" src="img/main5.jpg">
          </div>
        <div class="swiper-button-prev"><img src="img/prev.png"></div>
        <div class="swiper-button-next"><img src="img/next.png"></div>
      </div>
      </div>
      <div class="new">
        <strong>신제품 & 인기상품</strong>
      </div>
      <div class="multi">
        <div class="swiper-container s2">
          <div class="swiper-wrapper">
            <a href="#" class="swiper-slide" >
              <img src="img/b1.jpg">
              <p>SUPERCAST T7 4K HDMI 외장형캡쳐카드</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b2.jpg">
              <p>NKEY BT61 LED 2.0 블루투스 유무선 겸용 기계식 키보드</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b3.jpg">
              <p>BLOODY P91 PRO 게이밍 마우스</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b4.jpg">
              <p>NKEY K2-SE White LED 키보드</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b5.jpg">
              <p>NKEY K2-SE RAINBOW LED 기계식 키보드</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b6.jpg">
              <p>스카이디지탈 파워스테이션5 PS5-400N</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b7.jpg">
              <p>S122 4K 1 TO 2 HDMI SPLITTER (영상 분배기)</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b8.jpg">
              <p>슈퍼캐스트 T6 USB2.0 HDMI</p>
            </a>
            <a href="#" class="swiper-slide">
              <img src="img/b9.jpg">
              <p>SUPERCAST X LIVE 4K</p>
            </a>

          </div>
        <div id="prev" class="swiper-button-prev"><img src="img/prev.png"></div>
        <div id="next" class="swiper-button-next"><img src="img/next.png"></div>
      </div>
      </div>
    </section>

    <section id="section3">
      <div class="add_box">
        <a class="facebook" href="https://www.facebook.com/skydigitalkorea" target="_blank">
          <img src="img/facebook.jpg">
        </a>
        <a class="store" href="http://cater113.dothome.co.kr/shop/index.html" target="_blank">
          <img src="img/store.jpg">
        </a>
        <a class="blog" href="https://blog.naver.com" target="_blank">
          <img src="img/blog.jpg">
        </a>
      </div>
    </section>
  
    <section class="board_service">
      <div class="board_flex">
        <article class="notice">
          <div class="notice_subject">
            <h4>공지사항</h4>
            <a href="notice.do"><span>more</span></a>
          </div>
          <hr>

          <ul class="notice_content">
        <c:forEach var="list" items="${list }" >
          <!-- list -->
            <li><a href="view_notice.do?idx=${list.idx }">${list.subject }</a></li>
        </c:forEach>
          </ul>
        </article>
        <article class="news">
          <div class="news_subject">
            <h4>뉴스, 보도자료</h4>
            <span>more</span>
          </div>
          <hr>
          <ul class="news_content">
            <li><a href="#">2021년 설연휴 휴무 및 택배 A/S 마감 안내</a></li>
            <li><a href="#">2020년 추석 연휴 일정 및 배송안내</a></li>
            <li><a href="#">스카이디지탈 2020년 여름 휴가 안내</a></li>
            <li><a href="#">스카이디지탈 4월 ~ 5월 휴무 안내</a></li>
            <li><a href="#">2020년 설연휴 휴무 및 택배 A/S 마감 안내</a></li>
            <li><a href="#">2019 추석연휴 일정 및 배송안내</a></li>
            <li><a href="#">스카이디지탈 2019 여름 휴가 안내</a></li>
            <li><a href="#">스카이디지탈, 5월 휴무 안내</a></li>
          </ul>
        </article>
      </div>
      <article>
        <ul class="service_item">
          <li><a href="service5.do"><img src="img/service1.jpg"></a></li>
          <li><a href="#"><img src="img/service2.jpg"></a></li>
          <li><a href="#"><img src="img/service3.jpg"></a></li>
          <li><a href="#"><img src="img/service4.jpg"></a></li>
        </ul>
      </article>
    </section>
    
	<jsp:include page="footer.jsp"/>
    </div>
  </footer>
  </body>
</html>
