<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dto" items="${list }">
id : ${dto.id }<br>
name : ${dto.name }<br>
file name : 
<img src="${contextPath }/download?file=${dto.imgFileName }" alt="이미지 없음" width="100px" height="100px">
<a href="${contextPath }/download?file=${dto.imgFileName }">${dto.imgFileName }</a>
<br>
<a href="${contextPath }/modify_form?id=${dto.id }">수정</a>
<a href="${contextPath }/delete?file=${dto.imgFileName }&id=${dto.id}">삭제</a><hr>
</c:forEach>
<a href="${contextPath }/form">업로드 이동</a>

</body>
</html>