package kr.green.spring.service;

import kr.green.spring.vo.AccountVo;

public interface AccountService {
	public AccountVo signin(AccountVo accountVo);
	public boolean signup(AccountVo accountVo);
}
