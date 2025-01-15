package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MemberController {
	
	@Autowired MemberService ms;
	
	public MemberController() {
		System.out.println("----- MemberController 실행 -----");
	}
	
	@GetMapping("login")
	public String login(HttpServletRequest req) {
		System.out.println("----- login 연결 -----");
		HttpSession session = req.getSession();
		session.setAttribute("uid : ", req.getAttribute("id"));
		return "/member/login";
		
	}
	
	@PostMapping("successLogin")
	public String successLogin(MemberDTO dto, HttpServletRequest req ) {
		HttpSession session = req.getSession();
		session.setAttribute("uid : ", dto.getId());
		// 예: 데이터베이스나 다른 저장소와 사용자 인증
	    if ("expectedId".equals(dto.getId()) && "expectedPwd".equals(dto.getPwd())) {
	        // 로그인 성공 시 성공 페이지로 리다이렉트
	        return "redirect:successLogin";
	    } else {
	        // 로그인 실패 시 로그인 페이지로 리다이렉트
	        return "redirect:/login";
	    }
	}
	
	@GetMapping("successLogin")
	public String successLoginPage() {
	    System.out.println("----- successLogin 연결 -----");
	    return "/member/successLogin"; // 로그인 성공 페이지
	}

	@GetMapping("logout") // 한 번 더 확인
	public String logout(HttpServletRequest req) {
	    HttpSession session = req.getSession();
	    session.invalidate(); // 세션 무효화
	    return "redirect:/"; // 로그아웃 후 index.jsp로 이동
	}

	
	@GetMapping("register_form")
	public String registerForm() {
		System.out.println("----- registerForm 실행 -----");
		return "/member/register_form";
	}
	
	@PostMapping("register") // 한 번 더 확인
	public String register(HttpServletRequest req, MemberDTO dto) {
		System.out.println("----- register 실행 -----");
		System.out.println("req.id : " + req.getParameter("id") );
		 if ("expectedId".equals(dto.getId()) && "expectedPwd".equals(dto.getPwd())) {
		        // 로그인 성공 시 성공 페이지로 리다이렉트
		        return "redirect:successLogin";
		    } else {
		        // 로그인 실패 시 로그인 페이지로 리다이렉트
		        return "redirect:/";
		    }
	}
}
