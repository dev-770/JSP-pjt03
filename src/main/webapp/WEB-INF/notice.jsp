<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/board.css">
<title>Sktdigital</title>
</head>
<body>
  <jsp:include page="header.jsp" flush="true"/>
    <section class="back_color">
      <div class="tab_box">
        <div class="subject_box">
          <h3>공지</h3>
          <div class="board_search">
          <form action="search_notice.do">
            <input name="board_search" type="text" placeholder="공지검색">
            <button type="submit" class="search1">
            	<i class="fas fa-search"></i>
            </button>
           </form>
          </div>
        </div>
      </div>
      <div class="table_notice board text_center">
        <!-- menu -->
        <ul>
          <li class="w70 notice_color">번호</li>
          <li class="w850 notice_color">제목</li>
          <li class="w131 notice_color">작성자</li>
          <li class="w131 notice_color">작성일</li>
        </ul>
      	<c:forEach var="list" items="${list }" >
        <!-- list -->
        <ul class="over">
          <li class="w70 notice_border">${list.idx }</li>
          
          <li class="w850 notice_border">
          	<a id="subject" href="view_notice.do?idx=${list.idx }">${list.subject }</a>
          </li>
          
          <li class="w131 notice_border">${list.id }</li>
          <li class="w131 notice_border">${list.regdate }</li>
        </ul>
        </c:forEach>

		<c:if test="${empty list }"> <%-- list 값이 비어 있을 때 --%>
         <!-- list -->
        <ul>
          <li class="w70 notice_border">0</li>
          <li class="w850 notice_border">등록된 게시물이 없습니다.</li>
          <li class="w131 notice_border">.</li>
          <li class="w131 notice_border">.</li>
        </ul>
		</c:if>
	
	<c:forEach var="pg" items="${pg }"> <%-- paging nation --%>
	
      <c:if test="${pg.pg gt pg.block }"> <%-- pg > block --%>
      <ul class="btn">
      	<li class="page_btn"><a href="search_notice.do?pg=1&board_search=${search }">◀처음</a></li>
      </ul>
      </c:if>
      
      <c:forEach var="p" begin="${pg.startPage }" end="${pg.endPage }" step="1"> 
      	<c:choose>
      		<c:when test="${p eq pg.pg }"> <%--  p == pg (Select 시) --%>
		      <ul class="btn">
		      	<li class="page_select">${p }</li>
		      </ul>
      		</c:when>
      		<c:otherwise>
		      <ul class="btn">
		      	<li class="page_location"><a href="search_notice.do?pg=${p }&board_search=${search }">${p }</a></li>
		      </ul>
      		</c:otherwise>
      	</c:choose>
      </c:forEach>

      <c:if test="${pg.startPage lt pg.totalPage }"> <%-- startPage < totalPage --%>
      <ul>
          <li class="page_btn"><a href="search_notice.do?pg=${pg.totalPage }&board_search=${search }">끝▶</a></li>
      </ul>
	  </c:if>
	  
	</c:forEach>
      
     <c:if test="${sessionID != null }">
      <ul>
      	<li class="write" >
      		<a href="write_notice.do">글쓰기</a>
      	</li>
      </ul>
      </c:if>

      </div>
      </section>
      <div class="clear"></div>
  <jsp:include page="footer.jsp" flush="true"/>
</body>
</html>