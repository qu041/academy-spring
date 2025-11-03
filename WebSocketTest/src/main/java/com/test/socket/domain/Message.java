package com.test.socket.domain;

import lombok.Data;

/* 

클라이언트 <== (전송) ==> 서버

메시지 형식(=프로토콜 설계)
- JSON 형식(= 문자열)

- code: 상태코드
	- 1: 새로운 유저가 들어옴
	- 2: 기존 유저가 나감
	- 3: (전역) 메시지 전달
	- 4: (귓속말) 메시지 전달
	- 5: (전역) 이모티콘 전달
- sender: 메시지를 보낸 유저명(1사람)
- receiver: 메시지를 받는 유저명(전역(null), 귓속말(유저명))
- content: 메시지(대화내용)
- regdate: 발송 날짜/시간


*/
@Data
public class Message {
	
	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
	
	

}
