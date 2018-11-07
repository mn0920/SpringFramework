package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardLists(@Param("cri")Criteria cri, @Param("search")String search);
	public void registerBoard(@Param("boardVo")BoardVo boardVo);
	public BoardVo getBoard(@Param("num")int num);
	public void deleteBoard(@Param("num")int num);
	public void updateBoard(@Param("boardVo")BoardVo boardVo);
	public int getCountBoardLists(@Param("search")String search);
}
