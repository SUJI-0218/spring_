package com.care.aaa;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //여기 보는것처럼 controller가 없으면 console과 연결이 되지않음
@RequestMapping("my")
public class MemberController {
	@Autowired //bean으로 등록되어있는것들을 자동적으로 주입이 가능함
	MemberService ms; //ms, myService, autowired를 통해서 service의 객체가 불러와짐
	
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("ms => "+ ms);
		//콘솔로 통해서 ms는 service이기에 service의 객체를 가져옴
		ms.test();
		return "/test/index";
	}
	
	public MemberController() {
		System.out.println("MemberController");
	}
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public String index() {
		return "/get_post/index";
	}
	
//	@RequestMapping("my/result")이렇게 했을경우 get,post 둘 다 새용이 가능합, 하지만 위에 처럼 쓰게 되면 그 메소드에 맞게 사용이 가능함!
//	@RequestMapping(value="my/result", method = RequestMethod.GET)
	
	@GetMapping("result") //GetMapping을 쓰게 되면 method의 get방식이 사용이 가능함
	public String result(HttpServletRequest req, Model model) {
		//Model의 역할은 서버에서 생성한 데이터를 뷰(jsp 등)에 전달
//		ctrl에서 생성된 테이터를 jsp와 같은 화면으로 보내주는 데이터 전달 상자
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("age"));
		model.addAttribute("method", req.getMethod());//이 코드를 쓰면서 jsp파일로 변수명이 같이 넘어가서 쓸 수 있음
		model.addAttribute("age", req.getParameter("age"));
		model.addAttribute("name", req.getParameter("name"));
		//model.addAttribute("키", 값), ctrl에서 데이터를 뷰로 전달하기 위해 사용이 됨, 무조건 따라붙어야 되는 존재는 아님
		return "get_post/result";
	}
	
	//request를 통해 사용자의 정보가 담겨있고 사용자가 요청한 값을 들고 올 수 있음
//	@PostMapping("result") //동일한 값이 있으면 위에 보는것처럼 @RequestMapping("my") 이렇게 뺄 수 있음
//	public String poResult(HttpServletRequest req, Model model, String name, int age) {
//		System.out.println("name : " + name );
//		System.out.println("age : " + name );
//		return "get_post/result";
//	}
	//주석 기준, 위와 아래는 같은 방식이라고 생각을 하면 됨....
	
	@PostMapping("result") //동일한 값이 있으면 위에 보는것처럼 @RequestMapping("my") 이렇게 뺄 수 있음
//	req 사용자가 넘겨주는 방식
	public String poResult(HttpServletRequest req, Model model,
			@RequestParam("name") String n, int age) { //이 방식을 많이 씀
		System.out.println("name : " + n );
		System.out.println("age : " + age );
		
		model.addAttribute("method", req.getMethod());
		model.addAttribute("age", age);
		model.addAttribute("name", n);
		return "get_post/result";
	}
	@PostMapping("object")
	public String object(MemberDTO dto, Model model) {
		//select * from table where id=id;
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		model.addAttribute("member", dto);
		return "get_post/object";
	}
	@GetMapping("jstl")
	public String jstl(Model model) {
		//select * from table;
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		for( int i =0 ; i < 5 ; i ++ ) {
			MemberDTO d = new MemberDTO();
			d.setName("홍길동 : "+ i);
			d.setAge( i *10);
			list.add(d);
		}
		model.addAttribute("num", 100);
		model.addAttribute("list", list);
		return "get_post/jstl";
	}
}












