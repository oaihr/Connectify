package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		System.out.println("여기는 인터셉터 preHandle");
		String userId = (String)session.getAttribute("loginId");
		//로그인 안했으면? 진행 X -> 로그인부터 해라~
		if(userId == null) {
            session.setAttribute("msg", "로그인이 필요한 서비스입니다.");
            System.out.println("로그인이 되어있지않아서 로그인페이지로 리다이렉트");
            // 로그인 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/customer/login");
            return false; // 컨트롤러로 요청이 넘어가지 않도록 중단
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//System.out.println("여기는 인터셉터 postHandle");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//System.out.println("여기는 인터셉터 afterCompletion");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
