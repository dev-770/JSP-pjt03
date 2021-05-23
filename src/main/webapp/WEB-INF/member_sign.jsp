<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Skydigital</title>
<link rel="stylesheet" href="css/member.css">
    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
    <script src="js/member.js"></script>
</head>
<body>
      <section id="section1" class="back_color">
      <jsp:include page="header.jsp"/>
      <form name="Member" action="join.do" method="post">
        <div class="member">
          <div class="subject">
            <h3>회원 가입</h3>
          </div>
          <table class="member_table1">
            <tr id="id">
              <th>아이디</th>
              <td>
                <input type="text" name="id" maxlength="10">
                <span>영문자, 숫자, _만 입력가능. 최소 3자이상 입력하세요.</span>
              </td>
            </tr>
            <tr id="pw">
              <th>비밀번호</th>
              <td><input type="password" name="password1"></td>
            </tr>
            <tr id="pw">
              <th>비밀번호 확인</th>
              <td><input type="password" name="password2"></td>
            </tr>
          </table>
          <table class="member_table2">
            <tr id="name">
              <th>이름</th>
              <td><input type="text" name="name" maxlength="5"></td>
            </tr>
            <tr id="nic">
              <th>닉네임</th>
              <td>
                <input type="text" name="nickname">
                <span>공백없이 한글,영문,숫자만 입력 가능 (한글2자, 영문4자 이상)</span>
                <span>닉네임을 바꾸시면 앞으로 60일 이내에는 변경 할 수 없습니다.</span>
              </td>
            </tr>
            <tr id="mail">
              <th>E-MAIL</th>
              <td><input type="text" name="email"></td>
            </tr>
            <tr id="phone">
              <th>휴대폰번호</th>
              <td><input type="text" name=phone></td>
            </tr>
            <tr id="address">
              <th>주소</th>
              <td>
                <input id="zip" class="zip" type="text" name="zip">
                <input id="addr_search" type="button" onclick="execDaumPostcode()" value="주소검색"><br>
                <span>기본주소</span>
                <input id="addr1" class="addr1" type="text" name="addr1">
                <span>상세주소</span>
                <input id="addr2" class="addr2" type="text" name="addr2">
              </td>
            </tr>
          </table>
          <div class="sign_submit">
            <input type="button" value="회원가입" onclick="checkMember()">
            <input type="button" value="취소" onclick="location.href='home.do'">
          </div>
        </div>
        </form>
      </section>
      <jsp:include page="footer.jsp"/>
</body>
</html>