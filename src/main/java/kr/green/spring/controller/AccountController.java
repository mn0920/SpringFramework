package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.interceptor.LoginInterceptor;
import kr.green.spring.service.AccountService;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Integer loginOk, Model model) {
		if(loginOk == null)
			loginOk = -1;
		model.addAttribute("loginOk", loginOk);
		return "member/signin";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homepost(AccountVo accountVo, Model model) {
		AccountVo user = accountService.signin(accountVo);
		
		if(user == null) {
			model.addAttribute("loginOk", 0);
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signupGet() {
		return "member/signup";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo) {
		if(accountService.signup(accountVo))
			return "redirect:/";
		return "redirect:/signup";
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String loginGet() {
		return "member/signin";
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public String loginPost(String id, String pw) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		return "redirect:/signup";
	}
	
	// method가 없으면 post와 get둘다 한다.
	@RequestMapping(value="/signout")
		public String signout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			return "redirect:/";
	}
}
