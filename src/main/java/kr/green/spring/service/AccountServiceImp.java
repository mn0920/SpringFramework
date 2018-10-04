package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Override
	public boolean login(AccountVo accountVo) {
		String dbPw = accountDao.getPw(accountVo.getId());
		if(dbPw == null || dbPw.compareTo(accountVo.getPw()) != 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		//DB에서 email값에 null값 허용하지 않는 경우만 사용가능
		String emails = accountDao.getEmail(accountVo.getId());
		if(emails != null)
			return false;
		accountDao.setAccount(accountVo);
			return true;
	}
	
}
