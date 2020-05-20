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
	<c:set var = "i" value='${chkUserResult }'/>
	<c:choose>
		<c:when test="${i == true }">
			<script>
				alert("로그인 성공!!")
				location.href = "successLogin"
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("로그인 실패ㅜㅜ")
				location.href="login"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>