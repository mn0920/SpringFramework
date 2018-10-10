package kr.green.spring.dao;

import java.util.List;

import kr.green.spring.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardLists();
	public void registerBoard(BoardVo boardVo);
	public BoardVo getBoard(int num);
}
