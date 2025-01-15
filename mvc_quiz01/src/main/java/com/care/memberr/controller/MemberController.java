package com.care.memberr.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.memberr.dto.MemberDTO;
import com.care.memberr.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	public MemberController() {
		System.out.println("---MemberController---");
	}
	@GetMapping("index")
	public String index(String name, Model model, MemberDTO dto) {
		
		System.out.println("---index---");
		System.out.println("name : " + name);
		model.addAttribute("name", name);
		System.out.println("name: " + dto.getName()); 
		return "/memberr/index";
	}
	
	@GetMapping("list")
	public String list() {
		System.out.println("---list---");
		return "/memberr/list";
	}
	@GetMapping("login")
	public String login(MemberDTO dto, String id ) {
		System.out.println("---login---");
		if( dto.getId() == id ) {
			return "memberr/index";
		}else {
			return "redirect:login";
		}
	}
			
		
//		int result = ms.login(dto);
//		if( result == 1 ) {
//			return "/memberr/index";			
//		}else {
//			return "redirect:login";
//		}
//	}
	@GetMapping("register_form")
	public String registerForm() {
		System.out.println("---register_form---");
		return "/memberr/register_form";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		System.out.println("---register---");
		ms.register(dto);
		System.out.println("테스트 ::: " + ms.getList().size());
		return "/memberr/login";
	}
	

}
