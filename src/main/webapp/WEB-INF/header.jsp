<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/footer.css">
<script src="https://kit.fontawesome.com/9f304b8f3e.js" crossorigin="anonymous"></script>

    <div class="bar">
    <nav class="navbar">
        <div class="nav_logo">
          <a href="home.do">Sky digital</a>
        </div>
      <div class="m1">
        <ul class="nav_menu">
          <li class="drop1">
            <a href="company.do">회사소개</a>
            <ul class="sub_menu sub1">
              <li><a href="#">회사소개</a></li>
              <li><a href="#">총판안내</a></li>
              <li><a href="#">찾아오시는길</a></li>
            </ul>
          </li>
          <li class="drop2">
            <a href="notice.do">커뮤니티</a>
            <ul class="sub_menu sub2">
              <li><a href="#">공지</a></li>
              <li><a href="#">뉴스,보도자료</a></li>
              <li><a href="#">이벤트</a></li>
              <li><a href="#">HD게시판</a></li>
              <li><a href="#">매크로게시판</a></li>
            </ul>
          </li>
          <li class="drop3">
            <a href="#">제품</a>
            <ul class="sub_menu sub3">
              <li><a href="#">키보드</a></li>
              <li><a href="#">마우스</a></li>
              <li><a href="#">파워/쿨러</a></li>
              <li><a href="#">영상장비</a></li>
              <li><a href="#">음향기기</a></li>
              <li><a href="#">모바일</a></li>
              <li><a href="#">저장장치</a></li>
              <li><a href="#">PC악세사리</a></li>
              <li><a href="#">단종상품</a></li>
            </ul>
          </li>
          <li><a href="#" target="_blank">부품구입</a></li>
          <li><a href="service.do">고객지원</a></li>
        </ul>
        <div class="nav_search">
          <input type="text" placeholder="제품검색">
          <a href="#" class="search">
            <i class="fas fa-search"></i>
          </a>
        </div>
      </div>
      <div class="m2">
        <div class="nav_login">
          <c:if test="${sessionID == null }">
            <a href="login.do">로그인</a>
            <a href="join.do">회원가입</a>
          </c:if>
          <c:if test="${sessionID != null }">
            <span class="user">${name }</span>
            <a href="logout.do">로그아웃</a>
          </c:if>
        </div>
        <a href="#" class="nav_toggle">
          <i class="fas fa-bars"></i>
        </a>
      </div>
    </nav> <!-- nav -->
    </div>