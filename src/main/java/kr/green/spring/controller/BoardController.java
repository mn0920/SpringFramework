package kr.green.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.BoardService;

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
}
