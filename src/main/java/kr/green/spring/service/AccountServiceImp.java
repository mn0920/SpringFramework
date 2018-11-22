package kr.green.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.pagenation.Criteria;
import kr.green.spring.pagenation.PageMaker;
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

	
	
	@Override
	public List<AccountVo> getAccounts(HttpServletRequest request, Criteria cri) {
		//로그인한 아이디를 제외하고, super admin 권한을 가지고 있는 사람을 제외한 나머지를 가지고 오는 것
		AccountVo loginUser = getLoginUser(request);
		return accountDao.getAccountLists(cri, loginUser.getId());
	}

	@Override
	public void setAuthor(HttpServletRequest request, String id, String author) {
		HttpSession session = request.getSession();
		AccountVo loginUser = (AccountVo) session.getAttribute("user");
		System.out.println(author);
		//로그인한 아이디와 수정하려는 아이디가 같으면 세션에 있는 user 정보를 지우고 새로운 user 정보로 설정한다.
		if(loginUser != null && loginUser.getId().equals(id)) {
			session.removeAttribute("user");
			loginUser.setAuthor(author);
			session.setAttribute("user", loginUser);
		}
		accountDao.setAuthor(id, author);
	}

	@Override
	public PageMaker getPageMaker(HttpServletRequest request, Criteria cri, int displayPageNum) {
		AccountVo loginUser = getLoginUser(request);
		int totalCount = accountDao.getTotalCount(loginUser.getId());
		PageMaker pm = new PageMaker();
		pm.setCriteria(cri);
		pm.setDisplayPageNum(displayPageNum);
		pm.setTotalCount(totalCount);
		return pm;
	}

	@Override
	public AccountVo getLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AccountVo loginUser = (AccountVo) session.getAttribute("user");
		return loginUser;
	}
}
