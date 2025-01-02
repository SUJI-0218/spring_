<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="${contextPath }/register" method="post">
		<input type="text" name="id" placeholder="id"><br> 
		<input type="text" name="pwd" placeholder="password"><br> 
		<input type="text" name="name" placeholder="name"><br> 
		<input type="submit" value="가입">
		<!-- DTO에 대한 name, 여기서의 name이 같아야 사용이 가능함 -->
	</form>

</body>
</html>