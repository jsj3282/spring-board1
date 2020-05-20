package com.test.aop;

import java.text.ParseException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import com.test.service.LogSaveServiceImpl;

@Aspect
public class Test {
//	@Around("execution(* com.care.controller.MemberController.login())")
//	public Object commontLog(ProceedingJoinPoint joinpoint) {
//		try {
//			System.out.println("로그인 기능이 실행 됐습니다!!!");
//			System.out.println("파일 입출력을 통해 로그를 남깁니다!!!");
//			return joinpoint.proceed();
//		}catch(Throwable e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@After("execution(* com.care.controller.MemberController.chkUser(..))")
	public void startLog(JoinPoint join) {
		System.out.println("=============log start==============");
		LogSaveServiceImpl lss = new LogSaveServiceImpl();
		lss.loginstart();
	}
	
	@Before("execution(* com.care.controller.MemberController.logout(..))")
	public void endLog(JoinPoint join) throws ParseException {
		System.out.println("=============log end==============");
		LogSaveServiceImpl lss = new LogSaveServiceImpl();
		lss.loginend();
	}
	
}
