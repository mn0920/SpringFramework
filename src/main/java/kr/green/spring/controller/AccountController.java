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
	public String homeGet(Integer loginOk, Integer signup, Model model) {
		if(loginOk == null)
			loginOk = -1;
		if(signup == null)
			signup = -1;
		model.addAttribute("loginOk", loginOk);
		model.addAttribute("signup", signup);
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
	public String signupGet(Model model, Integer signup) {
		if(signup == null) {
			signup = -1;
		}
		model.addAttribute("signup", signup);
		return "member/signup";
	}
	
	/* 매개변수를 AccountVo 객체를 이용하면 jsp에서 name이 
	   id에 해당하는 정보가 AccountVo의 멤버변수 id에 저장이 된다. */
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		if(accountService.signup(accountVo)) {
			model.addAttribute("signup", 1);
			return "redirect:/";
		}
		model.addAttribute("signup", 0);
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
