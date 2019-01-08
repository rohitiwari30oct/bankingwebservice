package com.banking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomersList() {
		Session session = this.sessionFactory.getCurrentSession(); 
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.desc("created_at"));
			return criteria.list();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public Customer getCustomerByMobileno(String mobileno) {
		Session session = this.sessionFactory.getCurrentSession(); 
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("mobileno", mobileno));
		List<Customer> res = criteria.list();
		if(res!=null&&!res.isEmpty()) {
			return res.get(0);
		}
		return null;
	}

}











