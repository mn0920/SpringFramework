package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardLists();
	public void registerBoard(BoardVo boardVo);
}
