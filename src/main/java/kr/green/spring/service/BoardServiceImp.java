package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> getBoardLists(Criteria cri, String search, Integer type) {
		if (search == null) {
			search = "";
		}
		search = "%"+search+"%";
		// type에다 0이면 제목, 1이면 작성자, 2이면 내용이 되도록
		if (type == null) {
			type = 0;
		}
		if (type == 0) {
			return boardDao.getBoardListsByTitle(cri, search);
		} else if (type == 1) {
			return boardDao.getBoardListsByAuthor(cri, search);
		} else if (type == 2) {
			return boardDao.getBoardListsByContents(cri, search);
		} else {		
			return boardDao.getBoardListsByTitleAndContents(cri, search);
		}
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
	public int getCountBoardLists(String search, Integer type) {
		if (type == 0) {
			return boardDao.getCountBoardListsByTitle(search);
		} else if (type == 1) {
			return boardDao.getCountBoardListsByAuthor(search);
		} else if (type == 2) {
			return boardDao.getCountBoardListsByContents(search);
		} else {		
			// 게시물의 갯수를 가져오는 것이다. 그래서 String이 들어가도 상관X
			return boardDao.getCountBoardListsByTitleAndContents(search);
		}
	}

	@Override
	public PageMaker getPageMaker(String search, Integer page, int perPageNum, int displayPageNum, Integer type) {
		if (search == null) {
			search = "";
		}
		if (page == null) {
			page = 1;
		}
		if (type == null) {
			type = 0;
		}
		int totalCount = getCountBoardLists("%" + search + "%", type); // 검색된 컨텐츠의 갯수를 갖고온다
		// 이곳은 ServiceImp이기 때문에 boardService. 이걸 생략
		Criteria cri = new Criteria();
		cri.setPerPageNum(perPageNum);// 한 페이지당 보여줄 게시판의 수 - 없으면 10개씩 보여준다.
		cri.setPage(page);
		// 위에 것들이 있어야 계산을 할 수 있다.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setDisplayPageNum(displayPageNum);
		pageMaker.setTotalCount(totalCount);// 제대로 됬는지 다 보기위해서 확인하기 위한 것이기때문에 주석처리 가능함.
		return pageMaker;
	}

}
