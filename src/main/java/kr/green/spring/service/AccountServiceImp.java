package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public AccountVo signin(AccountVo accountVo) {
		AccountVo user = accountDao.getAccount(accountVo.getId());
		if(user == null || !passwordEncoder.matches(accountVo.getPw(), user.getPw()))
			return null;
		return user;
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		//DB에서 email값에 null값 허용하지 않는 경우만 사용가능
		String user = accountDao.getEmail(accountVo.getId());
		if(user != null)
			return false;
		String encPw = passwordEncoder.encode(accountVo.getPw());
		accountVo.setPw(encPw);
		accountDao.setAccount(accountVo);
			return true;
	}
	
}
