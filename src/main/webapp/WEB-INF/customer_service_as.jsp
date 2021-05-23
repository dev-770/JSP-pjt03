<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Skydigital</title>
    <link rel="stylesheet" href="css/as_style.css">
</head>
<body>
	<jsp:include page="header.jsp"/>
    <section id="section_as">
      <div class="tab_box">
        <div class="subject_box">
          <h3>고객지원</h3>
        </div>
      </div>
	<jsp:include page="service.jsp" flush="true"/>
    </section>
    <section id="section_map">
      <div class="area">
        <article class="mar_top20">
          <h4 class="sj"> 택배요청 </h4>
          <p class="f_white">구입영수증 기준 1개월 이내에 발생한 초기불량일 때는 영수증을 첨부해서
          <span class="f_red">계약된 CJ대한통운 택배</span>를 이용해 착불로 보내주세요. </p>
          <p class="f_white">(계약이 안된 편의점 CJ대한통운 택배는 제외입니다.)</p>
        </article>
        <article class="mar_top20">
          <p class="f_white">구입일로부터 1개월이 경과한 제품의 경우 CJ대한통운 택배나
          기타 다른 택배사를 이용해서 선불로 발송해주시면 됩니다.</p>
        </article>
        <article class="mar_top20">
          <p class="f_pur">전국 어디서나 <span class="f_pur">1588-1255</span></p>
          <p class="f_pur">택배비 분담은 A/S약관 공지를 참조하세요.
          <a id="btn" href="https://www.cjlogistics.com/ko/tool/parcel/reservation-general" target="_blank">대한 통운 예약 페이지 바로가기</a></p>
        </article>
        <article class="mar_top20">
          <h4 class="sj">택배 발송 시 유의사항</h4>
          <p class="f_white">택배 발송시 제품과 <span class="f_red">불량증상, 연락 가능한 연락처, 성함을 간단히 기재하신 후 동봉</span>하여 발송을 부탁드립니다.</p>
          <p class="f_white">(배송시 요구사항은 택배기사님이 보시는 메모입니다.)</p>
          <p class="f_white">빠른 AS를 위해 번거로우셔도 위의 사항을 꼭 지켜주세요 - !</p>
        </article>
      </div>
    </section>
    <jsp:include page="footer.jsp"/>
</body>
</html>