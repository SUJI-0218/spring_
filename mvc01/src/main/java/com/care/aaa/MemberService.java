package com.care.aaa;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ms") //ms,myService
public class MemberService {
	@Inject //10, 11번은 무조건 같이 써야 됨, 우리 수업에서는 auto만 쓸 예정 
	@Qualifier("memberDAO")
	MemberDAO dao;//500번대의 에러는 서버에서의 연산이 문제가 생겼을경우 발생이 됨
	public MemberService() {
		System.out.println("MemberService");
	}
	public void test() {
		System.out.println(dao +","+ "test 서비스 연결");
	}

}
