package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardListsByTitle(@Param("cri")Criteria cri, @Param("search")String search);
	public List<BoardVo> getBoardListsByAuthor(@Param("cri")Criteria cri, @Param("search")String search);
	public List<BoardVo> getBoardListsByContents(@Param("cri")Criteria cri, @Param("search")String search);
	public List<BoardVo> getBoardListsByTitleAndContents(@Param("cri")Criteria cri, @Param("search")String search);
	
	public void registerBoard(@Param("boardVo")BoardVo boardVo);
	public BoardVo getBoard(@Param("num")int num);
	public void deleteBoard(@Param("num")int num);
	public void updateBoard(@Param("boardVo")BoardVo boardVo);
	
	public int getCountBoardListsByTitle(@Param("search")String search);
	public int getCountBoardListsByAuthor(@Param("search")String search);
	public int getCountBoardListsByContents(@Param("search")String search);
	public int getCountBoardListsByTitleAndContents(@Param("search")String search);
}
