package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public String boardGet(Model model) {
		ArrayList list = null;
		list = (ArrayList)boardService.getBoardLists();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.GET)
		public String boardRegisterGet() {
			return "board/register";
	}
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public String boardRegisterPost(BoardVo boardVo) {
		boardVo.setAuthor("관리자");
		boardService.registerBoard(boardVo);
		return "redirect:/board/list";
	}
	
}
