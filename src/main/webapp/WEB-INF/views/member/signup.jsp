<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--  <link rel="stylesheet" href="/spring/resources/css/base_signup.css"> -->
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> 
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

    <title>Document</title>
</head>
<body>
    <div class="container">
        <form action="" method="POST">
        <div class="form-group">
            <div class="input-form">아이디 </div>
            <input type="text" name="id" placeholder="id" class="form-control">
        </div>
        <div class="form-group">
            <div class="input-form">비밀번호 </div>
            <input type="password" name="pw" placeholder="pw" class="form-control">
        </div>
        <div class="form-group">
            <div class="input-form">비밀번호 확인 </div>
            <input type="password" name="pwConfirm" placeholder="password check" class="form-control">
        </div>
        <div class="form-group">
            <div class="input-form">이메일 </div>
            <input type="email" name="email" id="" placeholder="email" class="form-control">
        </div>
        <div class="form-group">
        
            <div class="input-form">성별</div>
            <label for="male">남성</label>
            <input type="radio" name="gender" id="male" checked value="male">
            <label for="female">여성</label>
            <input type="radio" name="gender" id="female" value="female">
        </div>
        <div>
            <button type="submit" id="submit" class="btn btn-primary">제출</button>
        </div>
        </form>
    </div>
</body>
</html>