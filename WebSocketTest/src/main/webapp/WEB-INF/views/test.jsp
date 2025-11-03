<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://bit.ly/3WJ5ilK" />
</head>
<body>
	<!-- test.jsp  -->
	<h1>WebSocket <small>사용법</small></h1>
	
	<div>
		<button type="button" id="btn-connect">서버 연결하기</button>
		<button type="button" id="btn-disconnect">서버 연결끊기</button>
	</div>
	
	<hr>
	
		<div>
			<input type="text" class="long" id="msg">
			<button type="button" id="btn-echo">에코 테스트</button> 
		</div>
		
	<hr>
	
	<div class="massage full" id="message"></div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/dayjs@1.11.18/dayjs.min.js"></script>
	<script>
			
		//서버 식별 방법 >  서버측 종단점(END-POINT) = IP Address + Port Number
		const url = 'ws://localhost:8080/socket/server.do';
		
		//웹 소켓
		let ws;
	
	
		document.getElementById("btn-connect").onclick = () => {
			
			log('연결하기 버튼을 클릭했습니다.');
			
			if (ws != null && ws.readyState ==1) {
				log('이미 서버와 연결되어 있습니다.');
				return;
			}
			//1. 소켓 생성
			//2. 서버 접속(전화 걸기) + 연결
			//3. 통신
			//4. 서버 접속 종료
			
			//1. 소켓 생성 + 2. 서버 접속(전화 걸기) + 연결
			log('소켓을 생성합니다.');
			ws = new WebSocket(url); // 전화기 생성 + 전화 걸기
			log('소켓을 생성했습니다. > ' + ws.readyState);
			
			/* setTimeout(() => {
				
				log('소켓상태 > ' + ws.readyState);
				
			},1000); */
			
			//소켓 상태 프로퍼티
			//ws.readyState
			//0: 연결 전
			//1: 연결 완료(***)
			//2: 연결 종료 중
			//3: 연결 종료
			
			//클라이언트측 이벤트
			//서버측에서 소켓 연결 요청을 수락 후 > 클라이언트에게 결과를 통보 > 서로 연결이 되는 순간 발생
			ws.onopen = evt => {
				log('서버와 연결되었습니다.');
				log('소켓 상태: >' + ws.readyState);
				
			};
			
			//소켓 연결이 끊기는 순간 발생
			ws.onclose = evt => {
				log('서버와 연결이 끊겻습니다.');
				log('소켓 상태: >' + ws.readyState);
				
			};
			
			//서버가 클라이언트에게 메시지 전달 > 수신하는 순간 발생
			ws.onmessage = evt => {
				log('서버로부터 받은 데이터: ' + evt.data);
				
			};
			
			//소켓 통신 에러
			ws.onerror = evt => {
				log('에러가 발생했습니다.');
			};
			
		};
		
		document.getElementById("btn-disconnect").onclick = () => {
			
			//소켓 닫기
			if (ws.readyState == 1) {
			ws.close();
			}
		};
		
		function log(msg) {
			document.getElementById('message').innerHTML 
				= `<div>[\${dayjs().format('HH:mm:ss')}] \${msg}</div>` 
					+ document.getElementById('message').innerHTML;
		}
		
		document.getElementById('btn-echo').onclick = () => {
			
			if (ws == null || ws.readyState != 1) {
				log('서버와 연결이 되어있지 않습니다.');
				return;
			}
			
			//현재 연결되어 있는 소켓을 사용해서 서버에게 데이터를 전달
			ws.send(document.getElementById('msg').value);
			
			log('메시지를 전송했습니다.');
			
		};
		
		//console.log(new Date().toLocaleTimeString());
		//console.log(dayjs().format('YYYY-MM-DD HH:mm:ss'))
	</script>
	
</body>
</html>