package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public String getEmail(String id);
	public String getPw(String id);
	public void setAccount(AccountVo accountVo);
}
