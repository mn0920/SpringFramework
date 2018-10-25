package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.vo.AccountVo;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	   public String boardListGet(Model model, Integer page) {
	      if(page ==null)
	         page = 1;
	      int totalCount = boardService.getCountBoardLists();
	      Criteria cri = new Criteria();
	      cri.setPage(page);
	      
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCriteria(cri);
	      pageMaker.setDisplayPageNum(10);
	      pageMaker.setTotalCount(totalCount);
	      
	      System.out.println(pageMaker);
	      
	      ArrayList list = null;
	      list = (ArrayList)boardService.getBoardLists(cri);
	      model.addAttribute("list", list);
	      model.addAttribute("pageMaker", pageMaker);
	      return "board/list";
	   }
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
		public String boardRegisterGet(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		AccountVo user = (AccountVo)session.getAttribute("user");
		if(user != null)
			model.addAttribute("author", user.getId());
			return "board/register";
	}
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public String boardRegisterPost(BoardVo boardVo) {
		boardService.registerBoard(boardVo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
		public String boardDetailGet(Model model, int num) {
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("board", boardVo);
			return "board/detail";
	}

	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String boardDeleteGet(int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
		public String boardModifyGet(Model model, Integer num) {
		//정상 경로로 수정페이지에 접근한게 아니면
			if(num == null) {
				return "redirect:/board/list";
			}
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("board", boardVo);
			return "board/modify";
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String boardModifyrPost(BoardVo boardVo) {
		boardService.updateBoard(boardVo);
		return "redirect:/board/list";
	}
	
	
}
