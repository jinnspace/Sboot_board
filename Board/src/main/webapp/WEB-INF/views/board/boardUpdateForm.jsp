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
<h1>게시글 수정</h1>
<form name="frm" method="post" action="boardUpdate" >
<input type="hidden" name="BRDNO" value="${dto.BRDNO}">
<table>
	<tr><th>작성자</th><td>
		<input type="hidden" name="ID" value="${dto.ID}">${dto.ID}</td></tr>	
	<tr><th>제목</th><td><input type="text" value="${dto.BRDNAME}" size="12" name="BRDNAME"></td></tr>
	<tr><th>내용</th><td><textarea cols="70" rows="15" name="BRDCONTENT">${dto.BRDCONTENT}</textarea></td></tr>
</table><br>
<input type="submit" value="수정" ><input type="button" value="목록" onclick="location.href='boardList'"><br>
<div style="color:red">${message}</div>
</form>
</div>
</body>
</html>