package com.banking.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.banking.entity.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Transaction> getTransactionList(Date day) {
		Session session = this.sessionFactory.getCurrentSession(); 
		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.addOrder(Order.desc("created_at"));
		Date endDate = new Date(day.getTime()+TimeUnit.DAYS.toMillis(1));
		criteria.add(Restrictions.ge("created_at", day)).add(Restrictions.lt("created_at", endDate));
			return criteria.list();
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(transaction);
		
	}

	@Override
	public Transaction getTransaction(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction theTransaction = currentSession.get(Transaction.class, theId);
		return theTransaction;
	}


}
