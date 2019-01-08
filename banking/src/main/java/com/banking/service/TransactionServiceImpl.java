package com.banking.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banking.dao.TransactionDao;
import com.banking.entity.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionDao transactionDao;
	@Override
	public List<Transaction> getTransactionList(Date day) {
		return transactionDao.getTransactionList(day);
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		transactionDao.saveTransaction(transaction);
	}

	@Override
	public Transaction getTransaction(int theId) {
		return transactionDao.getTransaction(theId);
	}


}
