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
	<h1 style="text-align:center; color:burlywood; font-size:60px; font-family:Gabriola;">CARE &nbsp; WEB</h1>
		<div align="right">
		<c:choose>
			<c:when test="${sessionScope.mySession != null}">
				<hr>
				<a href="/controller/index">HOME</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/controller/memberInfo">회원 정보</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/controller/showLog">로그보기</a>
				&nbsp;&nbsp;&nbsp;
				<a href="/controller/logout">로그아웃</a>
				<hr>
			</c:when>
			<c:when test="${sessionScope.mySession == null }">
			<hr>
			<a href="/controller/index">HOME</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/controller/login">로그인</a>
			<hr>
			</c:when>
		</c:choose>
		</div>		
</body>
</html>