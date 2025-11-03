package com.test.java.aop;

public interface Memo {
		
	  
		//메모쓰기
	 	void add(String memo);
	 
	 
	 	//메모읽기
	 	String read(String seq) throws Exception;
	 	
	 	//메모 수정
	 	boolean edit(String seq,String memo);

	 	//메모삭제
	 	boolean del(String seq);
	 	
}
