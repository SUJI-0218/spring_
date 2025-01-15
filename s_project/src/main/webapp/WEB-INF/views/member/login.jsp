<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/default/header.jsp" />

	<form action="register" method="post">
		<input type="text" name="id" placeholder="아이디"><br> 
		<input type="password" name="pwd" placeholder="비밀번호"> 
		<input type="submit" value="로그인"><br>
		<a href="register_form">회원가입</a>
	</form>
<jsp:include page="/WEB-INF/views/default/footer.jsp" />
</body>
</html>