<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
	
		<c:if test="${list.size() != 0 }">
		<c:forEach var="d" items="${list }">
		<tr>
		<td>${d.name }</td>
		<td>${d.age }</td>
		</tr>
		
		</c:forEach>
	        목록들 존재
	    </c:if>
		<c:if test="${list.size() == 0 }">
		<tr>
	        <td colspan="2"><b>목록없음</b></td>
	        </tr>
	    </c:if>


	</table>
	<c:if test="${list.size() != 0 }">
	목록들 존재
	</c:if>
	<c:if test="${list.size() == 0 }">
	목록없음
	</c:if>
	size : ${list.size() }

	<hr>

	jstl.jsp
	<br> num : ${num }
	<br>
	<!-- jstl에서 사용 가능한 문법임 아래가 -->
	<c:if test="${num >= 100 }">
	100과 같거나 크다<br>
	</c:if>
	<!-- jstl에서 사용가능한 if문 -->
	<c:if test="${num > 80 }">
	80보다 크다<br>
	</c:if>
	<!-- if문은 c:if를 이용해서 사용가능하다, 단순하게 우리가 알고있는 if문이라고 보면 됨, 단순if문! -->

	<hr>

	<c:choose>
		<c:when test="${num >= 100 }"> 100<br>
		</c:when>
		<c:when test="${num > 80 }"> 80<br>
		</c:when>
		<c:otherwise>else 문</c:otherwise>
	</c:choose>
	<!-- 조건문 -->

	<hr>

	<!-- var는 변수 begin 시작값, 초기값, end는 끝값, step은 2씩 증가값 -->
	<c:forEach var="i" begin="10" end="16" step="2">
	${i },
	
	</c:forEach>

</body>
</html>