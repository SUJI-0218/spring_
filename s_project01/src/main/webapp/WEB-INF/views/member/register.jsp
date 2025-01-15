<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/daum_post.js"></script>
<script>
   
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/default/header.jsp" %><br> 
   <form action="${contextPath }/member/register" method="post">
      <input type="text" name="id" ><br>   
      <input type="password" name="pwd"><br>   
      <input type="text" name="addr" id="addr1" placeholder = "우편번호" readonly>
      <input type = "button" onclick = "daumPost()" value = "우편번호 찾기">
      <br>   
      <input type="text" name="addr" id="addr2" placeholder = "주 소" readonly>
      <input type="text" name="addr" id="addr3"placeholder = "상 세 주 소">
      <input type="submit" value="가입"><br>   
   </form>
</body>
</html>







