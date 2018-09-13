<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div>
        <form method="POST">
    <div>
        아이디 : <input type="text" name="id" placeholder="id">
    </div>
    <div>
        비밀번호 : <input type="password" name="password" placeholder="password">
    </div>
    <div>
        비밀번호 확인 : <input type="password" name="pwConfirm" placeholder="password check">
    </div>
    <div>
        이메일 : <input type="email" name="email" id="" placeholder="email">
    </div>
    <div>
        성별 : 
        <label for="male">남성</label>
        <input type="radio" name="gender" id="male" checked value="male">
        <label for="female"">여성</label>
        <input type="radio" name="gender" id="female" value="female">
    </div>
    <div>
        <button type="submit">제출</button>
    </div>
        </form>
    </div>
</body>
</html>