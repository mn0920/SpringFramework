package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardLists(Criteria cri, String search);
	public void registerBoard(BoardVo boardVo);
	public BoardVo getBoard(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardVo boardVo);
	public int getCountBoardLists(String search);
	public PageMaker getPageMaker(String search, Integer page, int perPageNum, int displayPageNum);
}
