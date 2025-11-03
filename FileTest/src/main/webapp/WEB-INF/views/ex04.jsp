<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- ex04.jsp  -->
	<h1>파일업로드<small>다중파일 + *AJAX*로 보내기</small></h1>
	
	<form id="form1">
		<table class="vertical">
			<tr>
				<th>텍스트</th>
				<td><input type="text" name="txt" value="홍길동"></td>
			</tr>
			<tr>
				<th>파일</th>
				<td><input type="file" name="attach" multiple></td>
			</tr>
		</table>
		<div>
			<button type="button" id="btnSend">보내기</button>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script>
			
		$('#btnSend').click(() => {
			
			//Ajax 객체 + 파일 업로드 > FormData 객체 사용
			const formData = new FormData(); // name=홍길동&age=20
			
			const files = $('input[name=attach]')[0].files;
			
			//전송할 데이터 담기
			formData.append('txt', $('input[name=txt]').val());
			
			for (let i=0; i<files.length; i++) {
				
				formData.append('attach', files[i]);
				
			}
			
			$.ajax({
				type:'post',
				url: '/file/ex04ok.do', //ajax용 요청 메서드
				data: formData,
				processData: false, //넘기는 데이터를 자동으로 문자열 변환
				contentType: false, //꺼줘야 브라우저가 자동으로 지정
				success:  function(result) {
					
				},
				error: function(a,b,c) {
					console.log(a,b,c);
				}
				
			});
			
			
		});

	
	</script>
	
</body>
</html>