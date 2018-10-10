<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
    <h2>Hoverable Dark Table</h2>
    <p>The .table-hover class adds a hover effect (grey background color) on table rows:</p>           
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
            <td>${board.title}</td>
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