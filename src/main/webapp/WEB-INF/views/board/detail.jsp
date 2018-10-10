<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
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
    <h3>게시글</h3>
    <form method="GET">
      <div class="form-group">
        <label for="title">제목</label>
        <input type="text" name="title" id="title" class="form-control" readonly value="${board.title}">
      </div>
      <div class="form-group">
        <label for="author">작성자</label>
        <input type="text" name="author" id="author" class="form-control" readonly value="${board.author}">
      </div>
      <div class="form-group">
        <label for="register_date">작성일자</label>
        <input type="text" name="register_date" id="register_date" class="form-control" readonly value="${board.register_date}">
      </div>
      <div class="form-group">
        <label for="contents">내용</label>
        <textarea name="contents" id="contents" rows="10" class="form-control" readonly>${board.contents}</textarea>
      </div>
      <a href="<%= request.getContextPath() %>/board/list"><button type="button" class="btn btn-primary">목록</button></a>
    </form>
  </div>
</body>
</html>