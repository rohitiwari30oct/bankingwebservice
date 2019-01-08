package com.banking.service;

import java.util.List;

import com.banking.entity.Account;


public interface AccountService {
	public List<Account> getAccountList();

	public void saveAccount(Account account);

	public Account getAccount(int theId);

}
