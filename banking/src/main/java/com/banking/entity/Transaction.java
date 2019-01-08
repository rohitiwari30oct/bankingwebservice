package com.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int transaction_id;
	@Column
	private Date created_at;
	@ManyToOne
    @JoinColumn(name = "db_accountid" )
	private Account debited_from;
	@Column
	private Date updated_at;
	@Column
	private Double amount;
	@ManyToOne
    @JoinColumn(name = "cr_accountid" )
	private Account credited_to;
	
	
	
	
	public Account getDebited_from() {
		return debited_from;
	}
	public void setDebited_from(Account debited_from) {
		this.debited_from = debited_from;
	}
	public Account getCredited_to() {
		return credited_to;
	}
	public void setCredited_to(Account credited_to) {
		this.credited_to = credited_to;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
