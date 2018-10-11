<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/global.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
    <h1>게시판 목록</h1>
    <p>게시글 목록입니다.
    <button type="button" class="btn btn-dark float-right"><a href="<%= request.getContextPath() %>/signout" id="signout">로그아웃</a></button></p>
    <table class="table table-dark table-hover">
      <thead>
        <tr>
          <th width="10%">번호</th>
          <th width="50%">제목</th>
          <th width="17%">작성자</th>
          <th width="23%">작성일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="board" items="${list}">
          <tr>
            <td>${board.num}</td>
            <td><a href="<%= request.getContextPath() %>/board/detail?num=${board.num}">${board.title}</a></td>
            <td>${board.author}</td>
            <td>${board.register_date}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/board/register">
      <button class="btn btn-primary"> 등록 </button>
    </a>
  </div>
</body>
</html>