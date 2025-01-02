package com.care.home_test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:application_db.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		DBClass db01 = ctx.getBean("db01", DBClass.class); //bean을 불러오는 설정
		System.out.println("id : " +db01.getId());
		System.out.println("pwd : "+db01.getPwd());
		
		System.out.println("------------");
		
		DBClass db02 = ctx.getBean("db02", DBClass.class);
		System.out.println("id : " +db02.getId());
		System.out.println("pwd : "+db02.getPwd());
		
	}
}
