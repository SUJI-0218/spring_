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
	list : ${list.size() }
	<table border="1">
		<tr>
			<th>id</th>
			<th>password</th>
			<th>name</th>
		</tr>
		<c:choose>
			
			<c:when test="${list.size() == 0 }">
				
				<tr>
					<td colspan="3" align="center"><b>데이터 없음</b></td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="mem" items="${list }">
					<tr>
						<td>${mem.id }</td>
						<td>${mem.pwd }</td>
						
						<td>
						<a href="info?id=${mem.id }"> <!-- 아이디의 값을 받아서 그 정보를 같이 넘겨준다... -->
						${mem.name }
						</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
		<td colspan="3" align="left"><a href="/member">index로 이동</a></td>
		</tr>
	</table>


</body>
</html>