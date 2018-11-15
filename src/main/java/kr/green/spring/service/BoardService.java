package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardLists(Criteria cri);
	public void registerBoard(BoardVo boardVo);
	public BoardVo getBoard(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardVo boardVo);
//	public int getCountBoardLists(String search, Integer type);
	public PageMaker getPageMaker(Criteria cri, int displayPageNum);
//	cri안에 현재 페이지정보가 다 들어있기 때문에 다른 정보들은 필요가 없으나, displayPageNum은 페이지네이션의 갯수기때문에 필요!
}
