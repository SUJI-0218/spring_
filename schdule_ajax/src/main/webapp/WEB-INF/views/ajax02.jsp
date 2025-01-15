<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 이 코드가 없으면 달러의 기능을 쓸 수가 없다! -->
<script type="text/javascript">
	function ajax02(){
		let n = document.getElementById("name").value; //자바스크립트 문법
		let a = $("#age").val(); //jquery 문법
		let form = { age : a, name : n }
		console.log("form : ", form )
		console.log("form type : ", typeof form )
		$.ajax({
			url : "result02", 
			type : "post", 
			data : JSON.stringify( form ), 
			dataType : "json", 
			contentType : "application/json;charset=utf-8",
			success : function( data ){
				console.log("data : ", data )
				//let msg = `name : ${data.name}<br>`; //jsp에서는 이 코드를 쓸 수가 없음!!!!!
				let msg = "name : " + data.name+"<br>";
				msg += "age : " + data.age
				$("#span").html( msg )
				
			},
			error : function(){
				alert("문제 발생")
			}
		})
	}
</script>
</head>
<body>
	name :
	<input type="text" id="name">
	<br> age :
	<input type="text" id="age">
	<br>
	<button onclick="ajax02()">전송</button>
	<br> 결과 :
	<span id="span"></span>

</body>
</html>