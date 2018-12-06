<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="code.jquery.com/jquery -3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
  <form method="POST" action="<%= request.getContextPath()%>/find/password">
    <input type="text" name="id" placeholder="아이디"> <br>
    <input type="email" name="email" placeholder="이메일"> <br>
    <button type="submit">확인</button>
  </form>
  <script type="text/javascript">
  var fail = ${fail};
  if(fail){
	  alert('아이디와 이메일이 일치하지 않습니다.')
  }
  </script>
</body>
</html>