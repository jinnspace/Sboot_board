<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/board.css" >
<script src="/script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 등록</h1>
	<form name="frm" method="post" action="boardWrite">
		<table>
			<tr><th>작성자</th><td>
				<input type="hidden" name="ID" value="${loginUser.ID}">${loginUser.ID}</td></tr> <!-- placeholder는 value와 다름 (데이터 저장 못함) -->
			<tr><th>제목</th>
				<td><input type="text" size="70" name="BRDNAME" value="${dto.BRDNAME}"></td></tr>
			<tr><th>내용</th>
				<td><textarea cols="70" rows="15" name="BRDCONTENT">${dto.BRDCONTENT}</textarea></td></tr>
		</table><br><br>
		<input type="submit" value="등록" onclick="alert('게시물 등록이 완료되었습니다.');"> 
		<input type="reset" value="다시 작성"> 
		<input type="button" value="목록" onclick="location.href='boardList'">
	</form><br><div style="color:red">${message}</div>
</div>
</body>
</html>