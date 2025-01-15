<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script><!-- 이 코드가 없으면 달러의 기능을 쓸 수가 없다! -->
<script type="text/javascript">
	function ajax(){
		//fetch("/ajax01");
		$.ajax({ 
			//url : "ajax01", 
			url : "result01", 
			type : "get",
			success : function( data ){ //함수안에 변수지정
				console.log("통신 성공")
				$("#count").html( data )
			},
			error : function() {
				console.log("문제 발생")
				
			}
		})
	}
</script>
</head>
<body>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<h1>11</</h1>
	<span id="count">0</span>
	<button onclick="ajax()">ajax</button>
</body>
</html>