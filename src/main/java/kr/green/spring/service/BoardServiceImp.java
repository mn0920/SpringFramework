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
	public List<BoardVo> getBoardLists(Criteria cri) {

		return boardDao.getBoardLists(cri);
		/*search = "%"+search+"%";
		이렇게 하면 검색창에 %%가 그대로 뜨는 경우가 있기때문에 Mapper에서 concat을 이용*/
		/* type에다 0이면 제목, 1이면 작성자, 2이면 내용이 되도록
		if (type == null) {
			type = 0;
		} 이젠 cri에서 알아서 해준다. */
	/*  이젠 mapper에서 할거임!
	  	if (type == 0) {
			return boardDao.getBoardListsByTitle(cri, search);
		} else if (type == 1) {
			return boardDao.getBoardListsByAuthor(cri, search);
		} else if (type == 2) {
			return boardDao.getBoardListsByContents(cri, search);
		} else {		
			return boardDao.getBoardListsByTitleAndContents(cri, search);
		}*/
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

/*
	타입에 따라 들어오는애가 달라서 있었는데, 지금은 Mapper에서 다할거기때문에 필요음슴
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
	}*/

	@Override
	public PageMaker getPageMaker(Criteria cri, int displayPageNum) {
		/*cri가 들어가기때문에 아래와 같은 상황은 걱정하지 않아도 된다
		if (search == null) {
			search = "";
		}
		if (page == null) {
			page = 1;
		}
		if (type == null) {
			type = 0;
		}*/
		int totalCount = boardDao.getCountBoardLists(cri); // 검색된 컨텐츠의 갯수를 갖고온다
		// 이곳은 ServiceImp이기 때문에 boardService. 이걸 생략
		/* cri가 들어오기때문에 필요가 음슴
		Criteria cri = new Criteria();
		cri.setPerPageNum(perPageNum);// 한 페이지당 보여줄 게시판의 수 - 없으면 10개씩 보여준다.
		cri.setPage(page);*/
		// 위에 것들이 있어야 계산을 할 수 있다.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setDisplayPageNum(displayPageNum);
		pageMaker.setTotalCount(totalCount);// 제대로 됬는지 다 보기위해서 확인하기 위한 것이기때문에 주석처리 가능함.
		return pageMaker;
	}

}
