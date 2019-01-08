package com.banking.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.model.TransactionModel;
import com.banking.model.TransactionResponseModel;
import com.banking.service.AccountService;
import com.banking.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountService accountService;
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public TransactionResponseModel transaction(@RequestBody TransactionModel transaction)
	{
		TransactionResponseModel response=new TransactionResponseModel();
		Account creditAccount=accountService.getAccount(transaction.getCredited_to());
		if(creditAccount==null||transaction.getCredited_to()==null) {
			response.setResponse("no such account exist of account number "+transaction.getCredited_to());
			return response;
		}
		Account debitAccount=accountService.getAccount(transaction.getDebited_from());
		if(debitAccount==null||transaction.getDebited_from()==null) {
			response.setResponse("no such account exist of account number "+transaction.getDebited_from());
			return response;
		}
		if(transaction.getAmount()==null||transaction.getAmount()<=0) {
			response.setResponse("incorrect transaction amount");
			return response;
		}
		if(debitAccount.getBalance()<transaction.getAmount())
		{
			response.setResponse("No sufficient balance");
			return response ;
		}
		else {
			try {
			debitAccount.setBalance(debitAccount.getBalance()-transaction.getAmount());
			creditAccount.setBalance(creditAccount.getBalance()+transaction.getAmount());
			Transaction trans=new Transaction();
			trans.setAmount(transaction.getAmount());
			trans.setCredited_to(creditAccount);
			trans.setDebited_from(debitAccount);
			trans.setCreated_at(new Date());
			transactionService.saveTransaction(trans);
			accountService.saveAccount(debitAccount);
			accountService.saveAccount(creditAccount);
			response.setResponse("Transaction successful");
			return response;
			}
			catch(Exception e)
			{
				response.setResponse("error occured try again");
				return response;
			}
		}
	}
		@RequestMapping(value = "/gettransaction/{day}", method = RequestMethod.GET)
		public List<Transaction> getTransaction(@PathVariable String day)
		{
			 SimpleDateFormat ddMMMMyyyy = new SimpleDateFormat("dd-MM-yyyy");
			 Date dt;
			try {
				dt = ddMMMMyyyy.parse(day);
				List<Transaction> transactionList=transactionService.getTransactionList(dt);
				return transactionList;
			} catch (ParseException e) {
				return null;
			}
		}
		@RequestMapping(value = "/addmoney/{accountno}/{amount}", method = RequestMethod.POST)
		public TransactionResponseModel addmoney(@PathVariable Integer accountno,@PathVariable Double amount)
		{
			TransactionResponseModel  response = new TransactionResponseModel();
			Account account=accountService.getAccount(accountno);
			if(account==null)
			{
				response.setResponse("wrong account number");
				return response;
			}
			if(amount==null||amount<1) {
				response.setResponse("wrong amount");
				return response;
			}
			else {
				account.setBalance(account.getBalance()+amount);
				accountService.saveAccount(account);
				Transaction trans=new Transaction();
				trans.setAmount(amount);
				trans.setCredited_to(account);
				trans.setDebited_from(null);
				trans.setCreated_at(new Date());
				transactionService.saveTransaction(trans);
				response.setResponse("Transaction successfull");
				return response;
			}
		}
		
}
