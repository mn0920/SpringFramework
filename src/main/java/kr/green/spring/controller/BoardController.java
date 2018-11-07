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
	   public String boardListGet(Model model, Integer page, String search) {
		  if(search == null) {
			  search="";
		  }
	      if(page ==null)
	         page = 1;
	      int totalCount = boardService.getCountBoardLists("%"+search+"%"); // 검색된 컨텐츠의 갯수를 갖고온다
	      Criteria cri = new Criteria();
	      //cri.setPerPageNum(10);//한 페이지당 보여줄 게시판의 수 - 없으면 10개씩 보여준다.
	      cri.setPage(page);
	      //위에 것들이 있어야 계산을 할 수 있다.
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCriteria(cri);
	      pageMaker.setDisplayPageNum(10);
	      pageMaker.setTotalCount(totalCount);//제대로 됬는지 다 보기위해서 확인하기 위한 것이기때문에 주석처리 가능함.
	      
	      System.out.println(pageMaker);
	      
	      ArrayList list = null;
	      list = (ArrayList)boardService.getBoardLists(cri, "%"+search+"%");
	      model.addAttribute("search", search);
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
		public String boardDetailGet(Model model, Integer num, Integer page, String search) {
			if(num== null)
				return "redirect:/board/list";
			if(page == null)
				page =1;
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("search", search);
			model.addAttribute("board", boardVo);
			model.addAttribute("page", page);
			return "board/detail";
	}

	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String boardDeleteGet(int num) {
		boardService.deleteBoard(num);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
		public String boardModifyGet(Model model, Integer num, Integer page, String search) {
		//정상 경로로 수정페이지에 접근한게 아니면
			if(num == null) {
				return "redirect:/board/list";
			}
			if(page == null)
				page =1;
			BoardVo boardVo = boardService.getBoard(num);
			model.addAttribute("search", search);
			model.addAttribute("board", boardVo);
			model.addAttribute("page", page);
			return "board/modify";
	}
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String boardModifyrPost(BoardVo boardVo, Integer page, Model model, String search) {
		if(page == null)
			page =1;
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		boardService.updateBoard(boardVo);
		return "redirect:/board/list";
	}
	
	
}
