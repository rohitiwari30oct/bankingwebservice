package com.banking.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.banking.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Account> getAccountList() {
		Session session = this.sessionFactory.getCurrentSession(); 
		Criteria criteria = session.createCriteria(Account.class);
		criteria.addOrder(Order.desc("created_at"));
		return criteria.list();
	}

	@Override
	public void saveAccount(Account account) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(account);
	}

	@Override
	public Account getAccount(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Account theAccount = currentSession.get(Account.class, theId);
		return theAccount;
	}


}
