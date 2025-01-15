function daumPost() {
    new daum.Postcode({ //주소코드
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            console.log( data.zonecode )
            document.getElementById("addr1").value = data.zonecode
            let addr = " ";
            if( data.userSelectedType =="J"){
            	addr = data.jibunAddress
            }else{
            	addr = data.roadAddress
            }
            document.getElementById("addr2").value = addr
            document.getElementById("addr3").focus()
        }
    }).open();
   }