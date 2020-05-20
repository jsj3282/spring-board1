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
		<form action="memberChk" method="post">
			<h1>회원 등록</h1>
			<input type="text" name="id" placeholder="아 이 디"><br>
			<input type="text" name="pwd" placeholder="비밀번호"><br>
			<hr>
			<input type="submit" value="회원가입">
		</form>
	</div>
	<footer>
		<c:import url="/footer">
		</c:import>
	</footer>
</body>
</html>