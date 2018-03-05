package org.reverside.bootcamp.ubereats.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Account {
	
	@Id
	@Column(name="account_num")
	private int accountNum;
	
	@Column(name="account_holder")
	private String accountHolder;
	
	@Column(name="card_number")
	@Length(min = 8)
	private int cardNumber;
	
	@Column(name="exp_date")
	private String expDate;
	
	private int cvc;
	
	@Column(name="branch_code")
	private int branchCode;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	
	//Constructors
	public Account() {}
	
	public Account(int accountNum, String accountHolder, int cardNumber, String expDate, int cvc, int branchCode,
			String paymentMethod) {
		super();
		this.accountNum = accountNum;
		this.accountHolder = accountHolder;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvc = cvc;
		this.branchCode = branchCode;
		this.paymentMethod = paymentMethod;
	}
	//Getter Setter Methods
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

}
