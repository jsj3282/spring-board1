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
		<h1 align="center">로&nbsp;그&nbsp;정&nbsp;보</h1>
		<table border="1">
		<tr>
			<th>번호</th><th>아이디</th><th>접속</th><th>종료</th><th>사용시간</th>
		</tr>
		<c:forEach items="${logs }" var="dto2">
		<tr>
			<td>${dto2.num }</td>
			<td>${dto2.id }</td>
			<td>${dto2.starttime}</td>
			<td>${dto2.endtime }</td>
			<td>${dto2.resulttime }</td>
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