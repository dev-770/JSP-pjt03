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
          <h3>°í°´Áö¿ø</h3>
        </div>
      </div>
	<jsp:include page="service.jsp" flush="true"/>
    </section>
    <section id="section_map">s
      <div class="load_map">
        <img src="img_as/map.jpg">
      </div>
    </section>
	<jsp:include page="footer.jsp"/>
</body>
</html>