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
		<h1>${userInfo.id } 정보</h1>
		아이디 : ${userInfo.id }<br>
		비밀번호 : ${userInfo.pwd }
	</div>
	<footer>
		<c:import url="/footer">
		</c:import>
	</footer>
</body>
</html>