<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath }" /> <!-- 변수 설정하는 방법 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${contextPath }/css/test.css">

</head>
<body>
<c:set var="aaa" value="값 지정" /> <!-- 변수 설정하는 방법 -->
${aaa }<br>

path : ${pageContext.request.contextPath }<br>
contextPath : ${contextPath }

<hr>
<img alt="" src="<c:url value='/resources/images/아리.jpg' />" width="100px" height="100px"><!-- 이 방법을 쓰면 서버의 이름을 바꿔도 이미지를 불러올 수 있기때문에 좀 더 안전성이 있다! -->
<!--  <img alt="" src="/member/resources/아리.jpg" width="100px" height="100px"> <!-- 이 방법을 쓸 경우 서버의 이름이 바뀔경우 이미지를 불러오지 않을 수가 있다 -->
<!--  <img alt="" src="${pageContext.request.contextPath }/resources/아리.jpg" width="100px" height="100px"> --> <!-- 20,21번 같은 값임 -->
<img alt="" src="${contextPath }/img/아리.jpg" width="100px" height="100px"> 
<a href="${contextPath }/register_form">회원가입</a> 
<a href="${contextPath }/list">모든 회원보기</a>
<a href="${contextPath }abc">abc</a> 
<!--  
<a href="/member/register_form">회원가입</a> 
<a href="/member/list">모든 회원보기</a>
<a href="/member/abc">abc</a>
-->

<!-- a태그는 get방식임, button onclick, location도 get 방식, form을 post방식 --> 

</body>
</html>