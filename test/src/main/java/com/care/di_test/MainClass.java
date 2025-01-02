package com.care.di_test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args ) {
		String path = "classpath:application_test.xml";
				GenericXmlApplicationContext ctx = new GenericXmlApplicationContext( path );
		PrintBean stb = ctx.getBean("main 사용", PrintBean.class);
		stb.Print();
	}
}
