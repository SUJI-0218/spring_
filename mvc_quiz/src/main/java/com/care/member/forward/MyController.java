package com.care.member.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	@GetMapping("login_form")
	public String loginForm() {
		return "login/login_form";
	}
	//forward를 통해서 민감한 정보를 가릴 수 있음, 연산을 다른 경로에서 진행이 가능하다
	@PostMapping("login")
	public String login(String id, String pwd) {
		return "forward:login_check";			
	}
	//forward를 통해서 경로를 노출시키지 않는다!
	//로그인에 대한 정보는 민감한 정보다 보니 16, 20번을 통해서 가려줄 수 있다.
	@PostMapping("login_check")
	public String loginCheck(String id, String pwd) {
		String dbId = "1", dbPwd = "1";
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			return "redirect:main";
		}else {
			return "redirect:login_form";
		}
	}
	@GetMapping("main")
	public String main() {
		return "login/main";
	}
	

}
