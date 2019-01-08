package com.banking.dao;

import java.util.List;

import com.banking.entity.Account;

public interface AccountDao {
	public List<Account> getAccountList();

	public void saveAccount(Account account);

	public Account getAccount(int theId);


}
