<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => { //페이지가 모두 로드된 후 실행되는 js 이벤트임
	//alert(111)
	console.log("model cook : " + '${cook}' )
	//model의 값은 달러+중괄호를 통해서 값을 얻어올 수 있음, 문자열이기 때문에 큰따음표, 작은따음표를 사용해야 됨
	//cook의 값이 
	//cookie : key=cookie값
	console.log("cookie : " + document.cookie ); // 이 방법이 좀 더 효과적임
	console.log("비교 : " + (document.cookie == "key=cookie값") );
	let url = "popup02";
	let setWindow = "width = 300, height=200, top=500, left=500" // 팝업창을 열어주는 문구
		//(document.cookie == key=cookie값) == false, 위아래 같은 문구임
	//if( !(document.cookie == "key=cookie값")){//이 방법을 써야 됨
		if('${cook}' != "key" ){
			window.open( url, "", setWindow ); //팝업 창은 window.open으로 통해서 열어짐	
	}	
}
</script>
</head>
<body>
기본페이지 입니다
</body>
</html>