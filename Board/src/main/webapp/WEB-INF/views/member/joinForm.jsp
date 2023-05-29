<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/board.css" >
<script type="text/javascript" src="/script/board.js"></script>
</head>
<body>
<div id="wrap" align="center"><h1>회원가입</h1>
<form name="frm" method="post" action="join">
* 는 필수 입력사항입니다. 
<table>
	<tr><th>아이디</th><td><input type="text" name="ID" size="20" value="${dto.ID}" maxlength="20"> * &nbsp;&nbsp;
			<input type="button" value="중복체크" onClick="idCheck();">	
			<input type="hidden" name="REID" value="${dto.REID}"></td></tr>
	<tr><th>비밀번호</th><td><input type="password" name="PWD" size="20" maxlength="20" value="${dto.PWD}"> *	</td></tr>
	<tr><th>비밀번호 확인</th><td><input type="password" name="PWDCHK" size="20" maxlength="20"> *</td></tr>
	<tr><th>이름</th>
		<td><input type="text" size="20" name="NAME" value="${dto.NAME}" maxlength="20"> *</td></tr>
	<tr><th>전화번호</th>
		<td><input type="text" size="20" name="PHONE" value="${dto.PHONE}" maxlength="20"> *</td></tr>
</table><br><br>
<input type="submit" value="등록"	>&nbsp;<input type="reset" 	value="다시 작성"> 
<input type="button" value="로그인 페이지로" onClick="history.go(-1);"><br><br>
<div style="color:red">${message}</div>
</form>
</div>
</body>
</html>