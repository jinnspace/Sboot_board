<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>���� ������</title>
<link rel="stylesheet" type="text/css" href="/css/board.css" >
<style type="text/css">
.lst{font-weight:bold; font-size:16px; color: green; text-align:center;}
</style>
</head>
<body>
<div id="wrap" align="center">
	<h1>�Խù�</h1>
		<c:choose>
			<c:when test="${loginUser.ID eq null}">
				<div style="float:right;"><a style="margin-left:10px" href="/">�α���/ȸ������</a></div>
			</c:when>
			<c:otherwise>
				<div class="lst" style="float:left;"> ${loginUser.NAME}(${loginUser.ID})�� ȯ���մϴ�.^^</div>
				<div style="float:right;"><a style="margin-left:10px" href="boardWriteForm">�Խñ� ���</a></div>
				<div style="float:right;"><a style="margin-left:10px" href="logout">�α׾ƿ�</a></div>
			</c:otherwise>
		</c:choose>
	
	<table class="list">
		<tr>
		</tr>
			
		<tr><th>��ȣ</th><th>����</th><th>�ۼ���</th><th>�ۼ���</th></tr>
		<c:forEach var="board" items="${list}">
			<tr class="record">	<td align="center">${board.BRDNO}</td>
				<td>
					<a href="boardView?BRDNO=${board.BRDNO}" style="text-align:center">${board.BRDNAME}</a>
				</td>
				<td align="center">${board.ID}</td>
				<td align="center"><fmt:formatDate value="${board.BRDINDATE}" /></td>
		</c:forEach>
	</table><br><br>
</div>

</body>
</html>