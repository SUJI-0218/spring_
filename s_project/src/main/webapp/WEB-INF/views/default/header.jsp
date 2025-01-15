<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><!--  // 한 번 더 확인 -->
</head>
<body>
CARE LAB
<hr>
<a href="/">HOME</a> <!-- header.jsp, server.xml, HomeController에서 다 설정을 줘야함 -->
<%
    String id = (String) session.getAttribute("id"); // 세션에서 로그인 상태 확인
%>
<% if (id != null) { %>
    <a href="logout">로그아웃</a> <!-- 로그인 상태: 로그아웃 링크 표시 -->
<% } else { %>
    <a href="login">로그인</a> <!-- 비로그인 상태: 로그인 링크 표시 -->
<% } %>
<hr>
</body>
</html>