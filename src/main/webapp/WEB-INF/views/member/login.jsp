<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> 
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form method="POST">
        <div class="form-group">
            <label for="">아이디</label> 
            <input type="text" name="id" placeholder="id" class="form-control">
        </div>
        <div class="form-group">
            <label for="">비밀번호</label>
            <input type="password" name="pw" placeholder="password"  class="form-control">
        </div>
        <div>
            <button type="submit" class="btn btn-default">로그인</button>
        </div>
        </form>
    <a href="<%= request.getContextPath() %>/signup">회원가입</a>
    </div>
</body>
</html>