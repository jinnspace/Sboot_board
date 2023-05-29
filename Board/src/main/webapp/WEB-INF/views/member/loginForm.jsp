<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/board.css" >
<script type="text/javascript" src="/script/board.js"></script>
</head>
<body>
	<form action="login" method="post">
		<div class="box"><h1>로그인</h1></div>
		<div class="box"><div class="attr1">아이디</div>
			<div class="attr2">&nbsp;&nbsp;<input type="text" size="20" name="ID"  style="width:200px; height:20px;" maxlength="20" value="${dto.ID}"></div>
		</div>
		<div class="box">
			<div class="attr1">비밀번호</div>
			<div class="attr2">&nbsp;&nbsp;<input type="password" size="20" name="PWD" style="width:200px; height:20px;" maxlength="20"></div>
		</div>
		<div class="box"><div id="footer">
			<input type="button" value="게시물 보기" onClick="location.href='boardList'"/>
			<input type="submit" value="로그인"/>
			<input type="button" value="회원가입" onClick="location.href='joinForm'"/>
		</div></div>
		<div class="box" style="color:red"><div id="footer">${message}</div></div>
	</form>
</body>
</html>