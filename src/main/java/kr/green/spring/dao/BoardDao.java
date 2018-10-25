package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardLists(@Param("cri")Criteria cri);
	public void registerBoard(BoardVo boardVo);
	public BoardVo getBoard(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardVo boardVo);
	public int getCountBoardLists();
}
