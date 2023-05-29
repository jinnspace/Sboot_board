<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
	<h1>게시글 상세보기</h1>
	<table>
		<tr><th>작성자</th><td>${board.ID}</td></tr>
		<tr><th>작성일</th><td><fmt:formatDate value="${board.BRDINDATE}"/></td>
		<tr><th>제목</th><td colspan="3">${board.BRDNAME}</td></tr>
		<tr><th>내용</th><td colspan="2"><pre>${board.BRDCONTENT}</pre></td></tr>
	</table><br> <br>
	<c:choose>
		<c:when test="${loginUser.ID != board.ID}">
			<input type="button" value="리스트로 돌아가기" onclick="location.href='boardList'">
		</c:when>
		<c:otherwise>
			<input type="button" value="리스트로 돌아가기" onclick="location.href='boardList'">
			<input type="button" value="수정" onclick="location.href='boardUpdateForm?BRDNO=${board.BRDNO}'">
			<input type="button" value="삭제" onclick="location.href='boardDelete?BRDNO=${board.BRDNO}'">
		</c:otherwise>
	</c:choose>
</div><br><br>



</body>
</html>







