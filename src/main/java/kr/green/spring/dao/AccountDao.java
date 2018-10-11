package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public String getEmail(String id);
	public String getPw(String id);
	//쿼리를 호출하기 위해서 만드는 것이고, interface로 만든다.
	public void setAccount(AccountVo accountVo);
	public AccountVo getAccount(String id);
}
