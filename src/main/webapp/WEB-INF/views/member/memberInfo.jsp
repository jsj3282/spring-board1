<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<c:import url="/header">
		</c:import>
	</header>
	<div align="center">
		<h1 align="center">회&nbsp;원&nbsp;정&nbsp;보</h1>
		<table border="1">
		<tr>
			<th>아이디</th><th>비밀번호</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td><a href="userInfo?id=${dto.id }">${dto.id }</a></td>
			<td>${dto.pwd }</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<footer>
		<c:import url="/footer">
		</c:import>
	</footer>
</body>
</html>