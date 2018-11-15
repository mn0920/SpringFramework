<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/global.css">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>

<body>
  <div class="container">
    <h1>게시글 수정</h1>
    <form method="POST" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" name="title" id="title" class="form-control"  value="${board.title}">
    </div>
    <div class="form-group">
      <label for="author">작성자</label>
      <input type="text" name="author" id="author" class="form-control" readonly value="${board.author}">
    </div>
    <div class="form-group">
      <label for="register_date">작성일자</label>
      <input type="text" id="register_date" class="form-control" readonly value="${board.register_date}">
    </div>
      <div class="form-group">
          <label>파일</label>
          <div>
          <c:if test="${board.file != null}">
            <a href ="<%= request.getContextPath() %>/board/download?fileName=${board.file}" class="black">${board.oriFile}</a>
          </c:if>
          <c:if test="${board.file == null}">없음</c:if>
          </div>
          <input type="file" class="form-control" name="files">
      </div>
    <div class="form-group">
      <label for="contents">내용</label>
      <textarea name="contents" id="contents" rows="10" class="form-control">${board.contents}</textarea>
    </div>
      <input type="hidden" value="${page}" name="page">
      <input type="hidden" value="${board.num}" name="num">
      <input type="hidden" value="${search}" name="search">
      <a href="<%= request.getContextPath() %>/board/list?page=${page}&search=${search}"><button type="button" class="btn btn-primary">취소</button></a>
      <button type="submit" class="btn btn-primary float-right">수정</button>
    </form>
</body>
</html>