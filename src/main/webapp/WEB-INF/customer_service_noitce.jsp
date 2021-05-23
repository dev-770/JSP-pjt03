<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sktdigital</title>
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
        <article class="as_notice">
          <h4> 1. 본 A/S 약관의 적용범위 </h4>
          <p>본 규정은 당사에서 제조 및 판매한 제품에 대하여 수리를 할 경우 보증기간이 경과되었거나,
          보증기간 이내라도 유상 수리에 해당될 경우 서비스 요금을 징수하는 업무에 대하여 적용합니다.</p>
        </article>
        <article class="as_notice">
          <h4> 2. 본 A/S 약관 공지의 목적 </h4>
          <p>본 규정은 서비스 요금을 합리적으로 결정함으로써 제품을 구입한 고객에게 공평한 서비스를 제공하고,
          요금산정 방법, 절차를 표준화함으로써 신뢰도를 높이며 업무의 공정을 기함에 목적이 있습니다.</p>
        </article>
        <article class="as_emp">
          <h3> 3. 제품 A/S 신청 방법 </h3>
          <span>→ 제품 구입 후 제품 사용 방법에 대한 질문, 기술 상담 그리고 기타 문의사항은
            당사 홈페이지(www.SkyOK.co.kr) 1:1 고객지원 게시판을 이용하여 주시기 바랍니다.</span>
          <p>→ 급한 문의사항은 당사 고객지원센터로 전화(02-712-7070) 문의 주시기 바랍니다.</p>
          <p>→ A/S 신청은 고객지원센터를 직접 방문하시거나, 택배를 이용하여 접수할 수 있습니다.</p>
        </article>
        <article class="as_emp">
          <h3> 4. 택배 이용 방법 </h3>
          <span>→ 영수증 기준 구입일로부터 1개월 이내에 발생한 초기 불량건은 지정 택배사 CJ대한통운
            택배를 이용해서 착불로 발송해주세요. 편의점 CJ대한통운 택배는 지정택배사가 아니니 착불로 보내시면 안됩니다.</span><br>
          <span>고객님께서 다른 택배사를 이용하여 기준 택배요금에서 초과분이 발생했을 때는 고객님께서 차액을 부담하셔야 합니다.</span><br>
          <span>→ 영수증 기준 구입일로부터 1개월 이후부터는 CJ대한통운택배나 기타 다른 택배사를 이용해서 선불로 발송해 주시면 됩니다. </span><br>
          <span>단, 우체국 일반 우편의 경우 분실의 위험이 크며, 분실에 대해서 책임을 지지 않습니다. 우체국을 이용할 때는 우체국 택배나 등기로 보내주세요.</span>
        </article>
      </div>
    </section>
	<jsp:include page="footer.jsp"/>
</body>
</html>