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
	<h1>로그인 페이지 입니다</h1>
	<form action="chkUser" method="post">
	<aside>
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="아이디"></td>
				<td rowspan='2'><input type="submit" value="로그인"></td>
			</tr>
			<tr>
				<td><input type="text" name="pwd" placeholder="비밀번호"></td>
			</tr>
		</table>
		<a href="member">회원가입</a>
	</aside>
	</form>
	</div>
	<footer>
		<c:import url="/footer">
		</c:import>
	</footer>
</body>
</html>