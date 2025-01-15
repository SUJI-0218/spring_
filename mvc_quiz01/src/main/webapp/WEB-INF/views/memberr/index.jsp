<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${list != id }">
			<script>
				alert("존재하는 ID가 없습니다.");
			</script>
		</c:when>
	</c:choose>


	${name}님 환영합니다.<br>
	<a href="/memberr/list">모든 회원보기</a>

</body>
</html>