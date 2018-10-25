package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardLists(Criteria cri);
	public void registerBoard(BoardVo boardVo);
	public BoardVo getBoard(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardVo boardVo);
	public int getCountBoardLists();
}
