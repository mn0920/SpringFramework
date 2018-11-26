<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardManagement</title>

<style>
.sub-menu{
    width : 200px;
    height: calc(93.5vh - 56px);
    /* vh:브라우저의 높이 : 100vh라면 100%같은 느낌이다.
    calc은 띄어쓰기를 통해 연산자를 구분한다. 즉, 띄어쓰기를 하지 않는다면 calc이 인식이 되지 않는다.
    = 브라우저 높이에서 nav높이를 뺌*/
    background-color: gray;
}
.sub-menu>ul{
    /*리스트의 마커 제거*/
    list-style : none;
    margin : 0;
    /*리스트의 들여쓰기를 제거*/
    padding : 0;
    text-align : center;
}
.sub-menu>ul>li{
    /*기본이 block이라 사실은 안 줘도 된다.*/
    display : block;
    height : 40px;
    /*문자열의 높이를 박스의 중간으로 하기 위해 line-height를 다르게 준다면, 그 수의 중간으로 들어간다.*/
    line-height : 40px;
    font-size : 23px;
    border-bottom : solid 1px white;
}
a{
    text-decoration : none;
    color :black;
}
.sub-menu a{
    color:white;
}
.sub-menu .select a{
    color:black;
}
.sub-menu .select{
    font-weight: bold;
    background-color: whitesmoke;
}
.contents{
 width : calc(100%);
 }
 .container-table{
 width : 860px;
 margin : 40px auto 0;
 }
 .navbar{
 min-width:860px; /* 화면의 최소값을 쥐어줘야 삐져나오지 않는다.(%로 하면 말이 달라지지만) */
 }
.dropdown:hover>.dropdown-menu {
  display: block;
}
.contents{
margin:auto;
}
.page-active .page-link{
    
}
</style>

</head>
<body>
<br><br>
  <div class="container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand/logo -->
    <a class="navbar-brand" href="#">Logo</a>
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> 관리자 페이지 </a>
        <div class="dropdown-menu">
          <c:if test="${user.author.equals('super admin')}">
            <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/cms/user">회원관리</a>
          </c:if>
          <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/cms/board">게시물관리</a>
        </div>
       </li>
      <li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a></li>
      <li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/board/list" id="signout">로그아웃</a></li>
    </ul>
    </nav>
   <!-- right box -->
   <div class="row">
   <div class="contents">
    <form method="POST">
      <div class="container-table">
        <table class="table table-bordered" width="860px">
          <thead>
            <tr>
              <th width="80px"><input type="checkbox"  id="checkall"> 선택</th>
              <th width="80px">번호</th>
              <th width="400px">제목</th>
              <th width="110px">작성자</th>
              <th width="190px">작성일</th>
            </tr>
          </thead>
          <tbody>
          
          <c:forEach var="bbs" items="${list}">
            <tr>
              <td><input type="checkbox" value="${bbs.num}" name="checkList"></td><!--  체크박스에 값을 넣어준다 -->
              <td>${bbs.num}</td>
              <td>${bbs.title}</td>
              <td>${bbs.author}</td>
              <td>${bbs.register_date}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
          <div id="pagination">
            <ul class="pagination justify-content-center">
              <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>">
                <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/board?page=${pageMaker.startPage - 1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-left"></i></a>
              </li>
              <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
                <li class="page-item <c:if test="${pageMaker.criteria.page == i}">active</c:if>">
                  <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/board?page=${i}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}">${i}</a>
                </li>
              </c:forEach>
              <li class="page-item <c:if test="${!(pageMaker.next)}">disabled</c:if>">
                <a class="page-link" href="<%=request.getContextPath()%>/admin/cms/board?page=${pageMaker.endPage + 1}&search=${pageMaker.criteria.search}&type=${pageMaker.criteria.type}"><i class="fas fa-angle-right"></i></a>
                </li>
              </ul>
            </div>
            <button type="submit" class="btn btn-outline-dark">삭제</button>
            <button type="button" class="btn btn-outline-dark"  id="allCheck">전체 선택</button>
         </div>
        </form>
      </div>
     </div>
  </div>
</div>
   <script type="text/javascript">
/* 	    //jQurey //최상단 체크박스 클릭
	    $("#checkall").click(function(){
	        //클릭되었으면
	        if($("#checkall").prop("checked")){
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=checkList]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=checkList]").prop("checked",false);
	        }
	    }); */
	    
	    //javascript
	    $('#allCheck').click(function(){
	    	var check = false;
	    	if($('input:checkbox[name="checkList"]:checked').length == 0)
	    		check = true;
	    	$('input:checkbox[name="checkList"]').each(function(){
                /* this.checked = check; */
                $(this).prop('checked', check);
	    	})
        });
   </script>
</body>
</html>