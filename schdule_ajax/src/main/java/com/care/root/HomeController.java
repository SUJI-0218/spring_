package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping("non_ajax")
	public String non_ajax() {
		System.out.println("non_ajax실행");

		return "non_ajax";
	}
	@GetMapping("ajax01")
	public String ajax01() {
		System.out.println("ajax01실행");

		return "ajax01";
	}
	
	int cnt = 0;
	@GetMapping("result01")
	@ResponseBody //이 값을 넣으면 jsp 값을 넘기는게 아니라 데이터의 값을 넘기는거라고 생각하면 됨
	public String result01() {
		return ++cnt + "";
		
	}
	
	@GetMapping("ajax02")
	public String ajax02() {
		System.out.println("ajax02실행");

		return "ajax02";
	}
	
	@PostMapping(value="result02", produces = "application/json;charset=utf-8")
	
	@ResponseBody
	public InfoDTO result02(@RequestBody InfoDTO dto) {//ajax를 이용해서 들어온 값은 requestbody를 사용을 함
		System.out.println("name : " + dto.getName());
		System.out.println("age : " + dto.getAge());
		dto.setName("변경 이름");
		dto.setAge(1111);
		return dto;
	}
	
}
