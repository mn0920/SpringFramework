package kr.green.spring.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String homeGet() {
		return "member/login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homepost(AccountVo accountVo, Model model) {
		boolean isLogin = accountService.login(accountVo);
		
		if(!isLogin)
			return "redirect:/";
		model.addAttribute("id", accountVo.getId());
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
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginGet() {
		return "member/login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String loginPost(String id, String pw) {
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		return "redirect:/signup";
	}
	
}
