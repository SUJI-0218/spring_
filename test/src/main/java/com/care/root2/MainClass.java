package com.care.root2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		STBean stBean = new STBean();//객체 생성
//		stBean.setName("홍길동");
//		stBean.setAge(20);
//		stBean.setSt( new Student() );
//		
//		stBean.namePrint(); //자바에서는 객체를 만들었지만 스프링에서는 bean을 많이 사용이 됨
//		stBean.agePrint();
		String path = "classpath:applicationST.xml"; //classpath는 src/main/resources의 파일이라고 생각하면됨
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		STBean stb = ctx.getBean("stb", STBean.class );
		
//		stb.setName("김개똥"); stb.setAge(300);
		stb.namePrint(); stb.agePrint();
	}

}
