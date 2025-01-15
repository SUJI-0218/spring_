package com.care.root.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	//interceptor를 쓰기 위해서는 상속을 받아주어야 함

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("index 실행 전 출력");
		HttpSession session = request.getSession();
		if( session.getAttribute("username") == null ) {
//			response.sendRedirect("login");
			String path = request.getContextPath();
			response.setContentType("text/html; charset=utf-8"); // 깨진 문자가 나오는데 그거를 한글로 변경하는 작업
			PrintWriter out = response.getWriter(); //위아래 코드로 인해서 사용자가 로그인 하지 않은 상태에서 경로를 이동을 하면 문자를 보여줄수 있겠금 출력하는 코드임
			out.print("<script>alert('로그인 하세요');location.href='/root/member/login';</script>");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("index 실행 후 출력");
	}

}
