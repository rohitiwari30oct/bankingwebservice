package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banking.dao.AccountDao;
import com.banking.entity.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDAO;
	@Override
	public List<Account> getAccountList() {
		
		return accountDAO.getAccountList();
	}

	@Override
	public void saveAccount(Account account) {
		accountDAO.saveAccount(account);	
		}

	@Override
	public Account getAccount(int theId) {
		return accountDAO.getAccount(theId);
		
	}

}
