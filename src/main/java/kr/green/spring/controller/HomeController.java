package kr.green.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
		return "redirect:/test";
	}
	
	@RequestMapping(value="/test", method =  RequestMethod.GET)
	public String testPost(Model model, String id) {
		model.addAttribute("id", id);
	      return "test/test";
	   }
	
	@RequestMapping(value="/test", method =  RequestMethod.POST)
	public String testPost(Model model, Integer num, Integer num2) {
		System.out.println("숫자 1 : " + num);
		System.out.println("숫자 2 : " + num2);
		if(num == null) num = 0;
		if(num2 == null) num2 = 0;
		Integer res = num + num2;
		model.addAttribute("num",  num);
		model.addAttribute("num2",  num2);
		model.addAttribute("res", res);
	      return "redirect:/";
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
