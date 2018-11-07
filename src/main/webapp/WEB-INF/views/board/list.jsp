<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/global.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#pagination {
  display: table;
  margin: 0 auto;
}
</style>
</head>
<body>
  <div class="container">
    <h1>게시판 목록</h1>
    <p>
      게시글 목록입니다.
      <button type="button" class="btn btn-dark float-right">
        <a href="<%=request.getContextPath()%>/signout" id="signout">로그아웃</a>
      </button>
    </p>
    <!-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="display:block;"> -->
    <form method="GET">
      <div class="input-group-append" style="width:100%">
        <div class="input-group mb-3" style="width:20%">
          <label for="sel1"></label>
          <select class="form-control" name="type">
            <option value="0" <c:if test="${type == 0 || type == null}">selected</c:if>>제목</option>
            <option value=1 <c:if test="${type == 1}">selected</c:if>>작성자</option>
            <option value=2 <c:if test="${type == 2}">selected</c:if>>내용</option>
            <option value=3 <c:if test="${type == 3}">selected</c:if>>제목+내용</option>
          </select>
          </div>
          <input type="text" class="form-control" placeholder="Search" name="search" value="${search}">
          <button class="btn btn-success" type="submit">검색</button>
      </div>
    </form>
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
            <td><a href="<%= request.getContextPath() %>/board/detail?num=${board.num}&page=${pageMaker.criteria.page}&search=${search}">${board.title}</a></td>
            <td>${board.author}</td>
            <td>${board.register_date}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div id="pagination">
      <!-- 가운데 정렬을 하기위해 div에 id를 부여했다. -->
      <ul class="pagination">
        <!-- ul은 부트스트렙 예제를 가지고 와서 고정된 1,2,3을 foreach로 바꾼것이다. -->
        <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>">
          <!-- c:if를 사용해서 사용이 가능하게, 가능하지 못하게 한 것이다. --> <a
          class="page-link"
          href="<%=request.getContextPath()%>/board/list?page=${pageMaker.startPage - 1}&search=${search}"><i class="fas fa-angle-left"></i></a>
        </li>
        <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
          <li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
            <!-- c:if문을 사용해서 현재 페이지에 색이 나오게 했다. -->
            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${i}&search=${search}">${i}</a>
          </li>
        </c:forEach>
        <li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
          <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pageMaker.endPage + 1}&search=${search}"><i class="fas fa-angle-right"></i></a>
        </li>
      </ul>
    </div>
    <a href="<%=request.getContextPath()%>/board/register">
      <button class="btn btn-primary">등록</button>
    </a>
  </div>
</body>
</html>