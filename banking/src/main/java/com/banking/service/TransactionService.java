package com.banking.service;

import java.util.Date;
import java.util.List;

import com.banking.entity.Transaction;

public interface TransactionService {
	public List<Transaction> getTransactionList(Date day);

	public void saveTransaction(Transaction transaction);

	public Transaction getTransaction(int theId);

}
