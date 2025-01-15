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

   <h3>login: ${ login }</h3>
   <c:choose>
      <c:when test="${ login == null }"> <!-- 띄워쓰기 틀리지 않도록 주의! -->
      <form action="login" method="post">
         <input type="text" name="id" placeholder="id"><br>
         <input type="password" name="pwd" placeholder="pwd"><br>
         <input type="submit" value="submit"><br>
      </form>
      </c:when>
      <c:otherwise>
         ${ login }님 로그인상태입니다!
      </c:otherwise>
   </c:choose>
   
</body>
</html>