package com.test.socket.server;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//종단점(IP + Port) 생성 + 소켓서버에게 부여
@ServerEndpoint("/server.do")
public class SocketServer {
	
	//여러가지 이벤트 구현
	//클라이언트가 연결 요청을 했을 때 발생
	//+ 연결 요청은 자동으로 수락된다.
	//- 이 이벤트가 발생했다면 이미 클라이언트와 연결이 성공된 상태
	@OnOpen
	public void handleOpen() {
		
		System.out.println("클라이언트와 접속되었습니다.");
		
	}
	
	//클라이언트와의 연결이 종료될 때 발생
	@OnClose
	public void handleClose() {
		
		System.out.println("클라이언트와 접속이 끊겼습니다.");
		
	}
	
	//클라이언트가 메시지를 전송 >  서버가 수신할 때 발생
	@OnMessage
	public String handleMessage(String msg) {
		System.out.println("클라이언트가 보낸 메시지: " + msg);
		
		return msg; // 클라이언트에게 전송 > echo
	}
	
	//에러시 발생
	@OnError
	public void handleError(Throwable e) {
		
		System.out.println("에러 발생: " + e.getMessage());
		
	}

	
}
