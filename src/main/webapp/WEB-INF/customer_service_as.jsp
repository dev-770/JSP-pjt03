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
          <h3>������</h3>
        </div>
      </div>
	<jsp:include page="service.jsp" flush="true"/>
    </section>
    <section id="section_map">
      <div class="area">
        <article class="mar_top20">
          <h4 class="sj"> �ù��û </h4>
          <p class="f_white">���Կ����� ���� 1���� �̳��� �߻��� �ʱ�ҷ��� ���� �������� ÷���ؼ�
          <span class="f_red">���� CJ������� �ù�</span>�� �̿��� ���ҷ� �����ּ���. </p>
          <p class="f_white">(����� �ȵ� ������ CJ������� �ù�� �����Դϴ�.)</p>
        </article>
        <article class="mar_top20">
          <p class="f_white">�����Ϸκ��� 1������ ����� ��ǰ�� ��� CJ������� �ù質
          ��Ÿ �ٸ� �ù�縦 �̿��ؼ� ���ҷ� �߼����ֽø� �˴ϴ�.</p>
        </article>
        <article class="mar_top20">
          <p class="f_pur">���� ��𼭳� <span class="f_pur">1588-1255</span></p>
          <p class="f_pur">�ù�� �д��� A/S��� ������ �����ϼ���.
          <a id="btn" href="https://www.cjlogistics.com/ko/tool/parcel/reservation-general" target="_blank">���� ��� ���� ������ �ٷΰ���</a></p>
        </article>
        <article class="mar_top20">
          <h4 class="sj">�ù� �߼� �� ���ǻ���</h4>
          <p class="f_white">�ù� �߼۽� ��ǰ�� <span class="f_red">�ҷ�����, ���� ������ ����ó, ������ ������ �����Ͻ� �� ����</span>�Ͽ� �߼��� ��Ź�帳�ϴ�.</p>
          <p class="f_white">(��۽� �䱸������ �ù������ ���ô� �޸��Դϴ�.)</p>
          <p class="f_white">���� AS�� ���� ���ŷο�ŵ� ���� ������ �� �����ּ��� - !</p>
        </article>
      </div>
    </section>
    <jsp:include page="footer.jsp"/>
</body>
</html>