package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
	@Bean
	public CommonsMultipartResolver multipartResolver() { //파일업로드를 진행할때는 이 코드가 등록이 되어야 파일업로드가 가능함
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		mr.setMaxInMemorySize(52428800); //50MB, 파일 크기 설정
		mr.setDefaultEncoding("utf-8"); //인코딩 설정
		return mr;
		}

}
