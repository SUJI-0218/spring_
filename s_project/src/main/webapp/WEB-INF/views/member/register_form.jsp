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
회원등록
	<form action="register" method="post">
		<input type="text" name="id" placeholder="아이디"><br> 
		<input type="password" name="pwd" placeholder="비밀번호"><br> 
		<input type="text" name="addr" placeholder="주소"><br>  
		<input type="submit" value="가입"><br>
	</form>
<jsp:include page="/WEB-INF/views/default/footer.jsp" />

</body>
</html>