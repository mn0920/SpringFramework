package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
			return true;
		}

	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		/* 컨트롤러에서 model.addAttribute를 통해 넘겨준 유저 정보를 modelMap 객체 생성하여 읽어옴 */
		ModelMap modelMap = modelAndView.getModelMap();
		AccountVo user = (AccountVo)modelMap.get("user");
		
		/* 유저정보가 null이 아니면 로그인 성공이므로 세션에 정보를 저장 
		 * 로그인을 유지하는 부분이다. 아래의 if부분이 */
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		System.out.println("LoginInterceptor : "+user);
	}
}
