<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 3,4 번처럼 쓰면 경로를 바꿔도 그거를 인식을 함으로 자동적으로 바꿔줌 -->
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<h1 align="center">CARE LAB</h1>
<hr>
<a href="${contextPath }">HOME</a> <!-- /root는 절대경로 -->
<a href="${contextPath }/member/list">회원정보</a>

<c:if test="${username != null }">

<a href="${contextPath }/member/logout">로그아웃</a>
</c:if>
<c:if test="${username == null }">
<a href="${contextPath }/member/login">로그인</a> <!-- 이렇게 바꾸면 변경되더라도 절대경로로 인식을하여 자동적으로 가게끔 만들어줌 -->

</c:if>

</body>
</html>