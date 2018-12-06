package kr.green.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
import kr.green.spring.vo.AccountVo;

public interface AccountService {
	public AccountVo signin(AccountVo accountVo);
	public boolean signup(AccountVo accountVo);
	
	public List<AccountVo> getAccounts(HttpServletRequest request, Criteria cri);
	public void setAuthor(HttpServletRequest request, String id, String author);
	public PageMaker getPageMaker(HttpServletRequest request, Criteria cri, int displayPageNum);
	public AccountVo getLoginUser(HttpServletRequest request);
  public boolean isDuplicated(String id);
  public boolean checkAccount(String id, String email);
  public void updatePw(String id, String pw);
}
