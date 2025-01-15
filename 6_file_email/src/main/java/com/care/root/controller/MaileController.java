package com.care.root.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.service.MailService;

@Controller
public class MaileController {
	@Autowired MailService ms;
	
	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse res, HttpServletRequest req) throws Exception {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		ms.sendMail("zzz2134@naver.com","test", "안녕");
		out.print("메일 전송 완료");
		}

	@GetMapping("sendmail02")
	public void sendMail02(HttpServletResponse res, HttpServletRequest req) throws Exception {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
//		String str = "<h1>안녕</h1>";
//		str += "<b>새로운 문자</b>";
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>안녕</h1>");
		sb.append("<b>새로운 문자</b>");
		sb.append("<a href='http://www.naver.com'>네이버</a>");
		String str = sb.toString();		
		
		ms.sendMail02("zzz2134@naver.com","test", str);
		out.print("메일 전송 완료");
		}
	
	@GetMapping("auth_form")
	public String authForm(HttpSession session) {
//		session.invalidate();
		return "auth_form";
	}
	
	@PostMapping("auth")
	public String auth(String email, HttpServletRequest req, HttpSession session) {
		ms.auth( email, req.getContextPath(), session );
		return "redirect:http://www.naver.com";
	}
	
	@GetMapping("auth_check")
	public String authCheck(String username, String userkey, HttpSession session) {
		String serverKey = (String) session.getAttribute("userkey");
		if( serverKey != null && serverKey.equals(userkey)) {
			session.setAttribute("username", serverKey);
		}
		System.out.println("----- 인증 확인 -----");
		return "redirect:auth_form";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
