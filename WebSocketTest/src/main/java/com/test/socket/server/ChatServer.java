package com.test.socket.server;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.socket.domain.Message;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	//현재 서버에 접속한 모든 클라이언트들
	//private static List<Session> sessionList;
	private static List<User> sessionList;
	
	static {
		sessionList = new ArrayList<User>();
	}
	
	//내부 클래스
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	class User {
		public String name;
		public Session session;
	}
	
	
	//이벤트
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("클라이언트가 접속했습니다.");
		
		User user = new User(null, session);
		
		sessionList.add(user);
		
		System.out.println(sessionList);
	}
	
	@OnClose
	public void handleClose() {
		System.out.println("클라이언트와 접속이 끊겼습니다.");
	}
	
	@OnMessage
	public void handleMessage(String message, Session session) {
		//System.out.println("클라이언트로부터 메시지가 도착했습니다.");
		
		//문자열(JSON 형식) > 파싱 + 매핑 > Message(DTO)로 변환 > GSON으로 사용
		
		System.out.println("메시지: " + message);
		Gson gson = new Gson();
		
		Message mdto = gson.fromJson(message, Message.class);
		
		//System.out.println(mdto);
		
		if (mdto.getCode().equals("1")) {
			
			//접속한 유저
			User user = null;
			
			for (User s : sessionList) {
				if (s.session== session) {
					user =s;
					break;
				}
			}
				
			user.name= mdto.getSender();
			//System.out.println(sessionList);
			
			//당사자 빼고 나머지 유저들에게 알려주기
			for (User s : sessionList) {
				if (s.session != session) {
					
					//이런걸 broadcast 한다고 함
					//-각각의 연결된 소켓으로 메시지 전달
					try {
						
						s.session.getBasicRemote().sendText(message);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (mdto.getCode().equals("2")) {
			//유저가 나갔습니다.
			User user = null;
			
			for (User s : sessionList) {
				if (s.session == session) {
					user =s; 
				}
			}
				
			sessionList.remove(user);
			
			for (User s : sessionList) {
				try {
					s.session.getBasicRemote().sendText(message);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		} else if (mdto.getCode().equals("3") || mdto.getCode().equals("5")) {
			
			//(전역) 메시지 > 모든 사람들에게 전달
			for (User s : sessionList) {
				if (s.session != session) {
					try {
						
						s.session.getBasicRemote().sendText(message);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (mdto.getCode().equals("4")) {
			
			for (User s : sessionList) {
				
				if (s.name.equals(mdto.getReceiver())) {
					
					try {
						
						s.session.getBasicRemote().sendText(message);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				
			}
			
		}
		
	}
	
	@OnError
	public void handleError(Throwable e) {
		System.out.println("에러가 발생했습니다.");
	}
	
}
