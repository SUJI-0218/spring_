package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //이거를 넣어줘야 MyController를 controller로 작동을 시키겠다고 알려줌
public class MyController {
	@RequestMapping("/index")
	public String test(Model model) {
		model.addAttribute("index","기본 페이지 입니다.");
		System.out.println("--- test 연동 ---");
		return "/member/index";
	}
	@RequestMapping("/logout")
	public String logout( ) {
		
		return "/member/logout"; //이 방법을 주로 많이 쓸거임
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login","로그인 페이지 입니다.");
		mv.setViewName("/member/login");
		return mv;
	}
}
