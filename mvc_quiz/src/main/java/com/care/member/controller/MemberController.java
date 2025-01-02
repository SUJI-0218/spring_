package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService ms; //service에서 객체 생성을 안해주면 오류가 발생이 될 수도있음
//	public MemberController(){
//		System.out.println("MemberController실행"); 
		//이 생성자를 먼저 넣고 가동이 되는지 확인 후 auto를 넣어서 서비스를 연결을 해야한다.
	@GetMapping("list") // 회원 목록
	public String list(Model model) {
		System.out.println("---list 연동---");
		ArrayList<MemberDTO> list = ms.getList();
		model.addAttribute("list", list );
		return "member/list";
	}
	@GetMapping("register_form") //회원가입
	public String registerForm() {
		System.out.println("---registerForm 연동---");
		return "member/register_form";
	}
	@PostMapping("register") //회원가입을 한 회원들의 정보를 저장하는
	//회원들의 목록을 ctrl -> service -> dao 를 통해서 데이터베이스에 저장을 한다.
	//그래서 service에도 register에 대한 값을 넘겨줘야함
	public String register(HttpServletRequest req, MemberDTO dto, String id, String name, String pwd) {
		System.out.println("---register---");
		System.out.println("req.id : " + req.getParameter("id"));
		System.out.println("dto.id : " + dto.getId());
		System.out.println("id : " + id); //36~38번은 같은 출력임
		ms.register(dto);
//		return "redirect:/";
		//index로 경로요청을 하면 경로가 /member/가 되어야하는데 register로 출력되는거를 볼수가 있음,redirect는 재요청을 해주세요! 라는 뜻! 모든내용을 다 처리하고 사용자한테 기본페이지를 요청하는 거임
		//사용자에게 다 보내고 다시 기본페이지 출력하는거
		return "redirect:test"; // 사용자한테 이 값을 보내서 재접속하는 느낌으로 보면 됨, 그래서 test가 보이게 됨
//		return "forward:test"; //경로는 registr로 고정되는데 서버내에서 자기들끼리 통신을 함
		
		//이 둘의 차이는 redirect는 사용자에게 보내고 재접속하는 것이라 get방식이라고 보면 됨
		//forward는 사용자가 요청한 방식을 그대로 따라감 forward를 이용하면 post방식이 유지된다고 보면 됨, 사용자가 요청한 것을 물려서 그대로 요청하는 값이기때문에 post방식임
		//forward는 연산처리하는 방식이라고 생각하면 됨
	}
	@GetMapping("test")
	public String test() {
		System.out.println("get방식 test 실행");
		return "index";
	}
	@PostMapping("test")
	public String test2() {
		System.out.println("@PostMapping방식 test 실행");
		return "index";
	}
	@GetMapping("abc")
	public String abc() {
		//중간에 무언가 연산 후 목록으로 이동시켜줌
		return "redirect:list";
		}
}
