package com.care.root.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	@Autowired(required = false) ServiceTest st;
	//serviceTest st로 객체를 생성을 하면 autowired를 써야 되는데 serviceTest에서 @service 오토먼트를 안써도 required를 이용해서 쓸 수 있다.

	@GetMapping("/cookie")
	public String cookie(HttpServletResponse res) {
		System.out.println("ServiceTest : " + st );
		Cookie cookie = new Cookie("key", "cookie값");//쿠키 생성, 객체 생성, key는 쿠키의 이름임
		cookie.setMaxAge(10);// cookie를 얼마동안 유지를 할것이냐에 대한것, 10초 동안 유지를 하겠다!
		res.addCookie(cookie);//응답에 쿠키 추가
		return "cookie";
	}

	@GetMapping("cookie_check")
	public String cookie_check(HttpServletRequest req, 
			@CookieValue(value = "key", required = false) Cookie cook) { // 쿠키
		//해당하는 값이 없으면 null 값을 이용을 하면 됨, cookieValue를 통해서 쿠키를 읽음	
		//value가 하나의 값일때는 "key"만 작성하면 됐었지만, value의 값이 없을때는 오류가 발생할 수 있기에 required를 false로 지정을 해둔다.																										// 가져옴
		System.out.println("cook : " + cook);
		if (cook != null) {
			System.out.println("cook name : " + cook.getName());
			System.out.println("cook value : " + cook.getValue());
			//쿠키가 있으면 cook.getvalue를 통해서 값을 가져올 수 있지만 없으면 null임
		}

		System.out.println("----------------------------------");
		Cookie[] cookie = req.getCookies(); //모든 쿠키를 가져옴
		for (Cookie c : cookie) { //반복문 통해 모든 쿠키 이름과 값을 출력함
			System.out.println(c.getName() + ":" + c.getValue());
		}
		return "cookie";
	}
	@GetMapping("cookie02")
	public String cookie02(Model model, 
			@CookieValue( value="key", required = false) Cookie cook) {//model은 사용자에게 값을  넘겨줄때 사용이 가능함, 쿠키의 값이 없다면 null값이 들어오고 값이 있으면 객체가 들어옴
		
		if( cook != null ) {
			model.addAttribute( "cook", cook.getName() ); //cook이라는 이름으로 데이터 저장
		}
		return "cookie02";
	}
	@GetMapping("popup02")
	public String popup02() {
		return "popup02";
	}
	@GetMapping("cookieCreate") //쿠키 유지하는 값
	public void cookieCreate(HttpServletResponse res) {
		Cookie cookie = new Cookie("key", "cookie값" );
		cookie.setMaxAge(5);
		cookie.setPath("/");
		res.addCookie(cookie);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
