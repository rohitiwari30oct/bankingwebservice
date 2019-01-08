package com.banking.model;

public class TransactionModel {
	private Integer debited_from;
	private Integer credited_to;
	private Double amount;
	
	
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getDebited_from() {
		return debited_from;
	}
	public void setDebited_from(Integer debited_from) {
		this.debited_from = debited_from;
	}
	public Integer getCredited_to() {
		return credited_to;
	}
	public void setCredited_to(Integer credited_to) {
		this.credited_to = credited_to;
	}
	
	
	
	

}
