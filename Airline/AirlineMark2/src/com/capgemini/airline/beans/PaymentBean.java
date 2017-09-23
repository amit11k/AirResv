package com.capgemini.airline.beans;

import java.util.Arrays;

public class PaymentBean {
	private int cvv;
	private String cardNumber;
	private int expMonth;
	private int expYear;
	private String name;
	private String mobNo;
	public PaymentBean() {
		// TODO Auto-generated constructor stub
	}

	public PaymentBean(int cvv, String cardNumber, int expMonth, int expYear,
			String name,String mobNo) {
		super();
		this.cvv = cvv;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.name = name;
		this.mobNo = mobNo;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	@Override
	public String toString() {
		return "PaymentBean [cvv=" + cvv + ", cardNumber=" + cardNumber
				+ ", expMonth=" + expMonth + ", expYear=" + expYear + ", name="
				+ name + ", mobNo=" + mobNo + "]";
	}

	

	
	
}
