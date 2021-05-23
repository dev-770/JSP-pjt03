<%@page import="java.util.List"%>
<%@page import="dao.NoticeDao"%>
<%@page import="dto.NoticeDto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/view.css">
  <title>Skydigital</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>
  <section id="section1">
    <div class="container">
      <ul class="title">
        <li>${notice.subject }</li>
      </ul>
      <ul class="sub">
        <div class="writer">
          <li><span>작성자</span><span class="val">${notice.id}</span></li>
          <li><span class="val">${notice.regdate }</span></li>
          <li><span>조회</span><span class="val"> ${notice.hit }</span><span>회</span></li>
          <li><span>댓글</span><span class="val"> 000</span><span>건</span></li>
        </div>
        <div class="btn">
          <li><a class="c_btn" href="#">답변</a></li>
          <li><a class="l_btn" href="notice.do">목록</a></li>
        </div>
      </ul>
      <ul>
        <li><span class="content"><img src="upload/${notice.filename }"> ${notice.content }</span></li>
      </ul>
      
      <c:choose>
      	<c:when test="${notice.id == sessionID || sessionID == 'admin' }">
      <ul class="writer_btn">
        <li><input id="update" type="button" onclick="location.href='update_notice.do?idx=${notice.idx}'" value="수정"></li>
        <li><input id="delete" type="submit" onclick= "location.href='delete_notice.do?idx=${notice.idx}'" value="삭제"></li>
      </ul>
      	</c:when>
      </c:choose>
    </div>
  </section>
  <section id="section2">
    <div class="container">
      <div class="comment_box">
        <ul class="comment">
          <li><span>comment</span><span class="ment_val">(-)</span></li>
        </ul>
        <ul class="comment_list">
          <li><div>등록된 댓글이 없습니다.</div></li>
        </ul>
        <ul>
          <li><span>댓글입력</span></li>
          <li><span>아이디 님</span></li>
        </ul>
        <ul>
          <li>
            <textarea name="comment" id="comment"></textarea>
            <input id="comment_btn" type="submit" onclick="javascript: form.action='comment.do'" value="등록">
          </li>
        </ul>
      </div>
    </div>
  </section>
  <jsp:include page="footer.jsp" flush="true"/>
</body>
</html>