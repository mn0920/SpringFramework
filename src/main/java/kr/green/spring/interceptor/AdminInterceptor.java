package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
			if(user == null||user.getAuthor().equals("user")) {
				response.sendRedirect(request.getContextPath());
				return false; // 컨트롤러에 들릴지 안들릴지를 결정여부(안 들리기때문에 false를 사용)
				//return이 false이면 컨트롤러를 방문하지 않는다.
			}
			return true;
		}

	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {

	}
}
