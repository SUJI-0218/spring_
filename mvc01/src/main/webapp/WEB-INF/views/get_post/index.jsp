<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>get 방식 전송</h3>
	<form action="result" method="get">
		<input type="text" name="name"><br> 
		<input type="text" name="age"><br> 
		<input type="submit" value="get전송"><br>
	</form>
	
	<h3>post 방식 전송</h3>
	<form action="result" method="post"> <!-- /가 있으면 절대 경로라고 생각하면 됨, /를 넣게 되면 my가 없어짐, 앞쪽에 /를 쓸거면 /root/my/result라고 사용을 해줘야 함 -->
		<input type="text" name="name"><br>
		<input type="text" name="age"><br> 
		<input type="submit" value="post 전송"><br>
	</form>
	
	<h3>object 방식 전송</h3>
	<form action="object" method="post"> 
		<input type="text" name="name"><br>
		<input type="text" name="age"><br> 
		<input type="submit" value="post 전송"><br>
	</form>

</body>
</html>