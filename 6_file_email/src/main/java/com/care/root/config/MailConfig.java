package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean
    public static JavaMailSender mailSender() {
   JavaMailSenderImpl jms = new JavaMailSenderImpl();
   jms.setHost("smtp.gmail.com");//google smtp 서버 설정, 네이버쓸거면 네이버를 쓰면 됨
   jms.setPort(587);//google smtp 메일 서버 포트, 구글의 포트 번호임
   jms.setUsername("tnwl80596@gmail.com");//보내는 계정
   jms.setPassword("cidqxywiaoseewtu");

   //메일 전달 프로토콜 세부 설정
   Properties prop = new Properties();
   prop.setProperty("mail.transport.protocol", "smtp");
//true면 사용자 인증을 시도한다.
   prop.setProperty("mail.smtp.auth", "true"); 
//tls 방식으로 처리되면 명시적 보안처리이다. 암시적은ssl이다
   prop.setProperty("mail.smtp.starttls.enable", "true"); //암호화 방식
   
//   prop.setProperty("mail.smtp.ssl.trust", "true");
//  // <prop key="mail.smtp.ssl.trust">smtp.gmail.com</prop>
//   prop.setProperty("mail.smtp.ssl.protocols", "true");
//  // <prop key="mail.smtp.ssl.protocols">TLSv1.2</prop>
   prop.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");// 암호화 방식
   jms.setJavaMailProperties(prop);
   return jms;
    }
}
