<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
   function daumPost() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
   }
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/default/header.jsp" %>
   <form action="${contextPath }/member/register" method="post">
      <input type="text" name="id"><br>   
      <input type="password" name="pwd"><br>   
      <input type="text" name="addr" placeholder = "우편번호" readonly>
      <input type = "button" onclick = "daumPost()" value = "우편번호 찾기">
      <br>   
      <input type="text" name="addr" placeholder = "주 소" readonly>
      <input type="text" name="addr" placeholder = "상 세 주 소">
      <input type="submit" value="가입"><br>   
   </form>
</body>
</html>







