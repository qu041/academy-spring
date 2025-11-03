package com.test.java.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

//보조 업무 > 로그 기록
public class Logger {

	//보조 업무 구현
	public void log() {
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[%tF %tT] 로그를 기록합니다.\r\n", now, now);
		
	}
	
	public void around(ProceedingJoinPoint jp) {
		
		//특정 업무가 실행되는 소요시간 (시간잴때 많이씀 성능테스트에 녹이면 될듯)
		long begin = System.nanoTime();
		//System.out.printf("[%tF %tT] 시작 전 로그를 기록합니다.\r\n", now, now);
		
		//주 업무 실행
		// > 가상객체를 만들어줌 >*** 프록시 객체(Proxy Object)
		
		try {
			jp.proceed();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		//System.out.printf("[%tF %tT] 로그를 기록합니다.\r\n", now, now);
		long end = System.nanoTime();
		System.out.println("소요시간: " + (end - begin) + "ns");
		
	}
	
}
