package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberSerivece;

public class AutoLogin extends HandlerInterceptorAdapter{

	@Autowired MemberSerivece ms;
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("-----auto login-----");
		Cookie cook = WebUtils.getCookie(request, "loginCookie");
//		System.out.println("cook : " + cook.getValue() );
		if( cook != null ) {
			MemberDTO dto = ms.getSessionId( cook.getValue() );
			System.out.println("dto :" + dto );
			if( dto != null ) {
				request.getSession().setAttribute("username", dto.getId() );
			}
			
		}
		return true; //모든 동작에서 얘를 걸처라는 소리임
	}
	
	

}
