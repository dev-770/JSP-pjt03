<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sktdigital</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<c:if test="${sessionID != null }">
	<script>
		alert("이미 로그인 중입니다.");
		location.href = "home.do";
	</script>
</c:if>
<c:if test ="${loginResult == 0 || loginResult == 1 }">
	<script>
		alert("아이디 및 비밀번호가 없습니다.");
	</script>
</c:if>
 <div class="wrap">
  	<form action="login.do" method="post">
    <div class="skin">
      <h1>로그인</h1>
        <div class="member_box">
        <div class="member">
          <h2>회원로그인</h2>
          <div class="login">
            <div class="login_put">
              <input type="text" name="id" placeholder="아이디">
              <input type="password" name="password" placeholder="비밀번호">
            </div>
            <input id="btn" type="submit" class="login_btn" value="로그인">
          </div>
          <div id="auto">
            <input type="checkbox" name="login_chk"><span id="auto_txt">자동로그인</span>
          </div>
        </div>

        <div class="sign">
          <h2>회원가입</h2>
          <p> 아직 회원이 아니시라면 가입후 이용해 주십시오.</p>
          <div class="sign_btn"><a href="join.do">회원가입</a></div>
        </div>
      </div>
      <div class="guide">
        <h3>회원로그인 안내</h3>
        <p>회원아이디 및 비밀번호가 기억 안나실 때는 아이디/비밀번호 찾기를 이용하십시오.</p>
          <div class="id_idx">
            <a href="#">아이디/비밀번호 찾기</a>
            <a href="home.do">메인으로 돌아가기</a>
          </div>
      </div>
    </div>
    </form>
  </div>
</body>
</html>