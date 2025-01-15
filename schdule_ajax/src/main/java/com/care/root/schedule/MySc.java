package com.care.root.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
//@EnableScheduling //이 어노테이션을 사용을 해야 스케줄러 기능으로 사용할 수가 있음
public class MySc {
	@Scheduled( cron = "*/10 * * * * *") //이 어노테이션을 사용을 해야 특정 시간에 맞게 사용이 가능함
	public void test1() {
		System.out.println("-----test1 실행------");
	}
	
	@Scheduled( cron = "0-59 * * * * *")
	public void test2() {
		System.out.println("+++++test2 실행++++++");
	}


}
