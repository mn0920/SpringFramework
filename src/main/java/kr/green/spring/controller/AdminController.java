package kr.green.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.service.AccountService;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.AccountVo;
import kr.green.spring.vo.BoardVo;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/cms/user")
	   public String cmsUser(HttpServletRequest request, Model model, Criteria cri) {
		cri.setPerPageNum(5);
		List<AccountVo> list = accountService.getAccounts(request, cri);
		PageMaker pm = accountService.getPageMaker(request, cri, 5);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pm);
	      return "admin/userManagement";
	   }
	
	@RequestMapping(value="/cms/user/modify")
	public String cmsUserModify(HttpServletRequest request, Model model, String id, String author) {
		accountService.setAuthor(request, id, author);
		return "redirect:/admin/cms/user";
	}
	
	@RequestMapping(value="/cms/board", method=RequestMethod.GET)
	   public String cmsBoardGet(Model model, Criteria cri) {
		List<BoardVo> list = boardService.getBoardLists(cri);
		PageMaker pm = boardService.getPageMaker(cri, 5);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pm);
	      return "admin/boardManagement";
	   }
	
	@RequestMapping(value="/cms/board", method=RequestMethod.POST)
	   public String cmsBoardPost(Model model, Integer [] checkList) {
		if(checkList != null) {
			for(Integer tmp : checkList) {
				boardService.deleteBoard(tmp);
			}
		}
	      return "redirect:/admin/cms/board";
	   }
}
