package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardVo> getBoardLists(Criteria cri) {
		return boardDao.getBoardLists(cri);
	}
	@Override
	public void registerBoard(BoardVo boardVo) {
		boardDao.registerBoard(boardVo);
	}
	@Override
	public BoardVo getBoard(int num) {
		return boardDao.getBoard(num);
	}
	@Override
	public void deleteBoard(int num) {
		boardDao.deleteBoard(num);
	}
	@Override
	public void updateBoard(BoardVo boardVo) {
		boardDao.updateBoard(boardVo);
	}
	@Override
	public int getCountBoardLists() {
		return boardDao.getCountBoardLists();
	}
	
}
