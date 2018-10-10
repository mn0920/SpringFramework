package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardVo> getBoardLists() {
		return boardDao.getBoardLists();
	}
	@Override
	public void registerBoard(BoardVo boardVo) {
		boardDao.registerBoard(boardVo);
	}
	@Override
	public BoardVo getBoard(int num) {
		return boardDao.getBoard(num);
	}
	
}
