<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet"  href="css/write.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <title>Skydigital</title>
  <script>
  $(document).on("change", ".file-input", function(){
	   
	    $filename = $(this).val();

	    if($filename == "")
	      $filename = "파일을 선택해주세요.";

	    $(".filename").text($filename);

	  })
  </script>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<section>
<form action="write_notice.do" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <th class="col1">제목</th>
      <td class="col1"><input id="subject" class="file-hidden" type="text" name="subject"></td>
    </tr>
    <tr>
      <th class="col1">작성자 : </th>
      <td class="col1">
		${sessionID }
      </td>
    </tr>
    <tr>
      <th class="col1">파일 올리기</th>
      <td class="col1 filebox" id="filebox">
      <label for="file">파일 찾기</label>
      <input class="file-input" id=file type="file" name="filename">
      <span class="filename">파일 선택해주세요.</span>
      </td>
    </tr>
    <tr>
      <td colspan="2"><textarea name="content"></textarea></td>
    </tr>
  </table>
  <div class="btn">
  	<input type="submit" value="글쓰기">
  </div>
  </form>
  <jsp:include page="footer.jsp" flush="true"/>
</body>
</html>