<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/memberr/login" method="post">
		<input type="text" name="id" placeholder="id"><br> 
		<input type="password" name="pwd" placeholder="password"><br> 
		<input type="submit" value="login"><br>
	</form>
	<a href="/memberr/register_form">회원가입</a>
	<a href="/memberr/list">모든 회원보기</a>
	<!--<jsp:include page="/WEB-INF/views/index.jsp" /> index파일을 include해서 가져옴 -->

</body>
</html>